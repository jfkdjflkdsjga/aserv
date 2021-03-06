/**
 * Copyright 2013 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2013-9-12 下午4:31:58
 */
package com.absir.aserv.system.bean.value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JaLang {

    /**
     * 国际化值
     *
     * @return
     */
    String value();

    /**
     * 同名识别字符
     *
     * @return
     */
    String tag() default "";
}
