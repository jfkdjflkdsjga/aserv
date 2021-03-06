/**
 * Copyright 2013 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2013-9-5 上午11:10:44
 */
package com.absir.aserv.menu.value;

import com.absir.aserv.menu.IMenuFactory;
import com.absir.aserv.menu.OMenuFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaFactory {

    String value() default "";

    Class<? extends IMenuFactory> factory() default OMenuFactory.class;

    MaMenu[] parent() default {};

    MaMenu menu() default @MaMenu;
}
