/**
 * Copyright 2013 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2013-6-19 下午2:43:31
 */
package com.absir.bean.inject;

import com.absir.bean.basis.BeanFactory;
import com.absir.bean.inject.value.InjectType;
import com.absir.core.kernel.KernelString;

import java.lang.reflect.Field;

public class InjectField extends InjectInvokerObserver {

    Field field;

    String value;

    public InjectField(Field field, String injectName, InjectType injectType) {
        super(injectType);
        this.field = field;
        this.value = KernelString.isEmpty(injectName) ? field.getName() : injectName;
    }

    @Override
    protected Object parameter(BeanFactory beanFactory) {
        return beanFactory.getBeanObject(value, field.getGenericType(), injectType == InjectType.Required);
    }

    @Override
    protected void invokeImpl(Object beanObject, Object parameter) {
        if (parameter == null) {
            if (injectType == InjectType.Required) {
                throw new RuntimeException("Can not inject " + field.getDeclaringClass() + ".field " + field);

            } else if (injectType != InjectType.ObServed) {
                return;
            }
        }

        try {
            field.set(beanObject, parameter);

        } catch (Exception e) {
            throw new RuntimeException("Can not inject " + beanObject + '.' + field + " : " + parameter, e);
        }
    }

    @Override
    public InjectObserver getInjectObserverImpl() {
        return new InjectObserverField(this);
    }
}
