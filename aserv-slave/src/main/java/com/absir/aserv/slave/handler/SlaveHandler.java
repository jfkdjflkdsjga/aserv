package com.absir.aserv.slave.handler;

import com.absir.bean.basis.Base;
import com.absir.bean.inject.value.Bean;
import com.absir.server.handler.HandlerType;
import com.absir.server.handler.IHandler;
import com.absir.server.on.OnPut;
import com.absir.server.value.Body;
import com.absir.server.value.Handler;
import com.absir.slave.ISlave;
import com.absir.slave.InputSlave;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by absir on 2016/10/27.
 */
@Base
@Bean
@Handler
public class SlaveHandler implements IHandler, ISlave {

    @Override
    public boolean _permission(OnPut onPut) {
        return InputSlave.onAuthentication(onPut.getInput());
    }

    @Override
    public void _finally(OnPut onPut, HandlerType.HandlerMethod method) {
    }

    @Override
    public long time() {
        return 0;
    }

    @Override
    public InputStream print(InputStream inputStream) {
        return null;
    }

    @Override
    public void merge(String entityName, @Body byte[] postData) throws IOException {

    }

    @Override
    public void option(String entityName, int option, @Body byte[] postData) {

    }
}