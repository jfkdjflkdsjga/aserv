/**
 * Copyright 2015 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2015年11月6日 下午5:20:05
 */
package com.absir.data.json;

import com.absir.core.kernel.KernelClass;
import com.absir.core.kernel.KernelList;
import com.absir.core.kernel.KernelList.Orderable;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"serial"})
public class DataDeserializationContext extends DefaultDeserializationContext {

    private List<JsonDeserializerResolver> resolvers;

    public DataDeserializationContext(DeserializerFactory df) {
        super(df, null);
    }

    protected DataDeserializationContext(DataDeserializationContext src, DeserializationConfig config, JsonParser jp,
                                         InjectableValues values) {
        super(src, config, jp, values);
        resolvers = src.resolvers;
    }

    protected DataDeserializationContext(DataDeserializationContext src) {
        super(src);
        resolvers = src.resolvers;
    }

    protected DataDeserializationContext(DataDeserializationContext src, DeserializerFactory factory) {
        super(src, factory);
        resolvers = src.resolvers;
    }

    public void addJsonDeserializerResolver(JsonDeserializerResolver resolver) {
        if (resolvers == null) {
            resolvers = new ArrayList<JsonDeserializerResolver>();
        }

        resolvers.add(resolver);
    }

    public void addJsonDeserializerResolverDone() {
        KernelList.sortOrderable(resolvers);
    }

    @Override
    public JsonDeserializer<Object> deserializerInstance(Annotated ann, Object deserDef) throws JsonMappingException {
        if (resolvers != null) {
            Class<?> rawClass = KernelClass.rawClass(ann.getGenericType());
            if (KernelClass.isCustomClass(rawClass)) {
                for (JsonDeserializerResolver resolver : resolvers) {
                    JsonDeserializer<Object> deserializer = resolver.forJavaType(rawClass);
                    if (deserializer != null) {
                        return deserializer;
                    }
                }
            }
        }

        return super.deserializerInstance(ann, deserDef);
    }

    @Override
    public JsonDeserializer<?> handleSecondaryContextualization(JsonDeserializer<?> deser, BeanProperty prop)
            throws JsonMappingException {
        if (resolvers != null) {
            if (deser.getClass() == BeanDeserializer.class) {
                BeanDeserializer deserializer = (BeanDeserializer) deser;
                Class<?> type = deserializer.handledType();
                for (JsonDeserializerResolver resolver : resolvers) {
                    JsonDeserializer<Object> jsonDeserializer = resolver.forJavaType(type);
                    if (jsonDeserializer != null) {
                        return jsonDeserializer;
                    }
                }
            }
        }

        return super.handleSecondaryContextualization(deser, prop);
    }

    @Override
    public DefaultDeserializationContext copy() {
        if (getClass() != DataDeserializationContext.class) {
            return super.copy();
        }

        return new DataDeserializationContext(this);
    }

    @Override
    public DefaultDeserializationContext createInstance(DeserializationConfig config, JsonParser jp,
                                                        InjectableValues values) {
        return new DataDeserializationContext(this, config, jp, values);
    }

    @Override
    public DefaultDeserializationContext with(DeserializerFactory factory) {
        return new DataDeserializationContext(this, factory);
    }

    public static interface JsonDeserializerResolver extends Orderable {

        public JsonDeserializer<Object> forJavaType(Class<?> type);

    }
}
