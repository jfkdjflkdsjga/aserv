/**
 * Copyright 2015 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2015年11月13日 下午3:53:04
 */
package com.absir.aserv.game.context;

import com.absir.aserv.system.bean.value.JaLang;
import com.absir.context.core.ContextBean;

public abstract class JbServerContext<SA> extends ContextBean<Long> {

    @JaLang("服务区")
    protected SA serverA;

    public SA getServerA() {
        return serverA;
    }

    @Override
    protected void initialize() {
        ServerService.ME.load(this);
    }

    /**
     * 载入数据
     */
    protected abstract void load();

    @Override
    public void unInitialize() {
        ServerService.ME.save(this);
    }

    /**
     * 保存数据
     */
    protected abstract void save();

    @Override
    public boolean stepDone(long contextTime) {
        return retainAt >= 0 && super.stepDone(contextTime);
    }

}
