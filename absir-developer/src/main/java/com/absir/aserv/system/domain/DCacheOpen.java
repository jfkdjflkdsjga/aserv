/**
 * Copyright 2015 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2015年11月19日 上午10:17:04
 */
package com.absir.aserv.system.domain;

import com.absir.aserv.system.bean.value.JiOpen;

public class DCacheOpen<V, K extends JiOpen> extends DCache<K, K> {

    public DCacheOpen(Class<K> entityClass, String entityName) {
        super(entityClass, entityName);
    }

    protected String genReloadHsql() {
        return "SELECT o FROM " + entityName + " o WHERE o.open = true";
    }

    @Override
    protected K getCacheValue(K entity) {
        return entity;
    }

}
