/**
 * Copyright 2014 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2014-1-14 上午11:00:59
 */
package com.absir.bean.config;

import com.absir.bean.core.BeanFactoryImpl;

public interface IBeanFactorySupport {

    public boolean supports(BeanFactoryImpl beanFactory);

}
