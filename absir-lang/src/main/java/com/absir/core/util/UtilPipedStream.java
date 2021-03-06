/**
 * Copyright 2015 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2015年10月22日 下午5:13:50
 */
package com.absir.core.util;

import com.absir.core.base.Environment;
import com.absir.core.kernel.KernelLang.ObjectEntry;
import com.absir.core.util.UtilStep.IStep;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class UtilPipedStream implements IStep {

    public static final UtilStep STREAM_STEP = UtilStep.openUtilStep(true, "UtilPipedStream.STEP", 5000);

    protected long idleTime;

    private int size;

    private int index;

    private Map<Object, NextOutputStream> addMapOutStream;

    private Map<Object, NextOutputStream> nextMapOutStream = new HashMap<Object, NextOutputStream>();

    public UtilPipedStream(long idleTime) {
        if (idleTime < 1000) {
            idleTime = 1000;
        }

        this.idleTime = idleTime;
        STREAM_STEP.addStep(this);
    }

    public static final void closeCloseable(Closeable closeable) {
        if (closeable == null) {
            return;
        }

        try {
            closeable.close();

        } catch (IOException e) {
            Environment.throwable(e);
        }
    }

    public static final long getHashIndex(int hashKey, int index) {
        long hashIndex = hashKey;
        hashIndex <<= 32;
        hashIndex += index;
        return hashIndex;
    }

    @Override
    public boolean stepDone(long currentTime) {
        if (idleTime > 0) {
            currentTime = UtilContext.getCurrentTime();
            Iterator<Entry<Object, NextOutputStream>> iterator = nextMapOutStream.entrySet().iterator();
            Entry<Object, NextOutputStream> entry;
            NextOutputStream outputStream;
            while (iterator.hasNext()) {
                entry = iterator.next();
                outputStream = entry.getValue();
                if (outputStream.passTime < currentTime) {
                    iterator.remove();
                    closeCloseable(outputStream);
                }
            }

            synchronized (this) {
                if (addMapOutStream != null) {
                    nextMapOutStream.putAll(addMapOutStream);
                    addMapOutStream = null;
                }

                size = nextMapOutStream.size();
            }

            return false;

        } else {
            for (NextOutputStream outputStream : nextMapOutStream.values()) {
                closeCloseable(outputStream);
            }

            nextMapOutStream.clear();
            synchronized (this) {
                if (addMapOutStream != null) {
                    for (NextOutputStream outputStream : addMapOutStream.values()) {
                        closeCloseable(outputStream);
                    }

                    addMapOutStream = null;
                }

                size = 0;
            }

            return true;
        }
    }

    public int getSize() {
        return size;
    }

    public synchronized void close() {
        idleTime = 0;
    }

    // 批量产出OutputStream
    public synchronized Entry<Integer, NextOutputStream> nextOutputStream(int hashKey) {
        if (idleTime > 0) {
            boolean maxed = false;
            long hashIndex = getHashIndex(hashKey, index);
            while (true) {
                if (getOutputStream(hashIndex) == null) {
                    NextOutputStream outputStream = createNextOutputStream();
                    addNextOutputStream(hashIndex, outputStream);
                    return new ObjectEntry<Integer, NextOutputStream>(index, outputStream);
                }

                if (index >= Integer.MAX_VALUE) {
                    if (maxed) {
                        return null;
                    }

                    maxed = true;
                    index = 0;
                    hashIndex = getHashIndex(hashKey, index);

                } else {
                    index++;
                    hashIndex++;
                }
            }
        }

        return null;
    }

    // 创建OutStream
    protected NextOutputStream createNextOutputStream() {
        return new NextOutputStream();
    }

    // 添加OutStream
    protected synchronized void addNextOutputStream(Object key, NextOutputStream value) {
        if (addMapOutStream == null) {
            addMapOutStream = new HashMap<Object, NextOutputStream>();
        }

        size++;
        value.retainAt();
        addMapOutStream.put(key, value);
    }

    // 获取hashIndex对应的OutputStream
    public NextOutputStream getOutputStream(Object hashIndex) {
        Map<Object, NextOutputStream> mapOutStream = addMapOutStream;
        NextOutputStream outputStream = nextMapOutStream.get(hashIndex);
        if (outputStream == null) {
            if (mapOutStream != null) {
                outputStream = mapOutStream.get(hashIndex);
            }
        }

        return outputStream;
    }

    public NextOutputStream getOutputStream(int hashKey, int index) {
        return getOutputStream(getHashIndex(hashKey, index));
    }

    // 强制创建hashIndex对应的OutputStream
    public NextOutputStream createNextOutputStream(Object hashIndex) {
        NextOutputStream outputStream = createNextOutputStream();
        setNextOutputStream(hashIndex, outputStream);
        return outputStream;
    }

    // 强制设置hashIndex对应的OutputStream
    public synchronized void setNextOutputStream(Object hashIndex, NextOutputStream value) {
        NextOutputStream outputStream = getOutputStream(hashIndex);
        if (outputStream != null) {
            closeCloseable(outputStream);
        }

        addNextOutputStream(hashIndex, value);
    }

    public static class WrapOutStream extends OutputStream {

        OutInputStream outInputStream;

        public WrapOutStream(OutInputStream inputStream) {
            outInputStream = inputStream;
        }

        @Override
        public void write(int b) throws IOException {
            outInputStream.write(b);
        }

        @Override
        public void close() throws IOException {
            outInputStream.close();
        }
    }

    public static class OutInputStream extends InputStream {

        public static final int DEFAULT_PIPE_SIZE = 1056;

        protected boolean closed;

        protected byte buffer[];

        protected int in = 0;

        protected int out = 0;

        public OutInputStream() {
            initPipe(DEFAULT_PIPE_SIZE);
        }

        public OutInputStream(int pipeSize) {
            initPipe(pipeSize);
        }

        private void initPipe(int pipeSize) {
            if (pipeSize <= 0) {
                throw new IllegalArgumentException("Pipe Size <= 0");
            }

            buffer = new byte[pipeSize];
        }

        private final void checkWrite(int len) throws IOException {
            if (closed) {
                throw new IOException("Block stream closed");
            }

            if (availableNIO() + len >= buffer.length) {
                flush();
                try {
                    wait(1000);

                } catch (InterruptedException e) {
                }

                if (availableNIO() + len >= buffer.length) {
                    throw new IOException("Block not enough buffer write");
                }
            }
        }

        public synchronized void write(int b) throws IOException {
            checkWrite(1);
            synchronized (buffer) {
                buffer[in] = (byte) (b & 0xFF);
                if (++in >= buffer.length) {
                    in = 0;
                }
            }
        }

        public synchronized void write(byte[] b, int off, int len) throws IOException {
            checkWrite(len);
            synchronized (buffer) {
                int last = in + len;
                if (last <= buffer.length) {
                    System.arraycopy(b, off, buffer, in, len);
                    in += len;
                    if (in >= buffer.length) {
                        in = 0;
                    }

                } else {
                    int l = buffer.length - in;
                    System.arraycopy(b, off, buffer, in, l);
                    in = len - l;
                    System.arraycopy(b, off + l, buffer, 0, in);
                }
            }

            flush();
        }

        public final void flush() {
            synchronized (buffer) {
                buffer.notifyAll();
            }
        }

        public int available() {
            if (readSpace()) {
                return 0;
            }

            return availableNIO();
        }

        protected final int availableNIO() {
            int av = in - out;
            if (av < 0) {
                av += buffer.length;
            }

            return av;
        }

        private final boolean readSpace() {
            try {
                while (in == out) {
                    if (closed) {
                        return true;
                    }

                    synchronized (buffer) {
                        buffer.wait(1000);
                    }
                }

            } catch (InterruptedException e) {
            }

            return false;
        }

        @Override
        public int read() throws IOException {
            if (readSpace()) {
                return -1;
            }

            synchronized (buffer) {
                if (in == out) {
                    return -1;
                }

                int b = buffer[out];
                if (++out >= buffer.length) {
                    out = 0;
                }

                return b;
            }
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            if (readSpace()) {
                return -1;
            }

            synchronized (buffer) {
                int av = in - out;
                if (av == 0) {
                    return -1;
                }

                if (av > 0) {
                    if (av > len) {
                        av = len;
                    }

                    System.arraycopy(buffer, out, b, off, av);
                    out += av;
                    if (out >= buffer.length) {
                        in = 0;
                        out = 0;
                    }

                } else {
                    av = buffer.length - out;
                    if (av > len) {
                        av = len;
                    }

                    System.arraycopy(buffer, out, b, off, av);
                    out += av;
                    if (out >= buffer.length) {
                        out = 0;
                    }
                }

                return av;
            }
        }

        @Override
        public void close() throws IOException {
            if (!closed) {
                synchronized (this) {
                    closed = true;
                    flush();
                }
            }
        }
    }

    public class NextOutputStream extends OutInputStream {

        protected long passTime;

        public NextOutputStream() {
            retainAt();
        }

        public final void retainAt() {
            passTime = UtilContext.getCurrentTime() + idleTime;
        }

        public void write(int b) throws IOException {
            super.write(b);
            retainAt();
        }

        public void write(byte[] b, int off, int len) throws IOException {
            super.write(b, off, len);
            retainAt();
        }

        @Override
        public void close() throws IOException {
            if (passTime > 0) {
                size--;
                passTime = 0;
                super.close();
            }
        }
    }

}
