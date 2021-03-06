/**
 * Copyright 2015 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2015年5月14日 上午10:28:04
 */
package com.absir.aserv.master.bean.base;

import com.absir.aserv.system.bean.base.JbBean;
import com.absir.aserv.system.bean.value.JaEdit;
import com.absir.aserv.system.bean.value.JaLang;
import com.absir.aserv.system.bean.value.JaName;
import com.absir.core.kernel.KernelLang;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class JbServerTargets extends JbBean {

    @JaLang(value = "目标服务", tag = "targetServer")
    @JaName("JSlaveServer")
    @JaEdit(groups = JaEdit.GROUP_LIST)
    @Column(length = 10240)
    @Type(type = "com.absir.aserv.system.bean.type.JtJsonDynamic")
    private long[] serverIds;

    private transient long[] lastServerIds;

    @JaLang("全部服务")
    private boolean allServerIds;

    private transient int lastAllServerIds;

    @JaLang("组号")
    private String[] groupIds;

    private transient String[] lastGroupIds;

    @JaLang("备注")
    @JaEdit(groups = JaEdit.GROUP_LIST)
    private String mark;

    public long[] getServerIds() {
        return serverIds;
    }

    public final void setServerIds(long[] serverIds) {
        if (lastServerIds == null) {
            lastServerIds = this.serverIds;
        }

        this.serverIds = serverIds;
    }

    public long[] getLastServerIds() {
        return lastServerIds;
    }

    public boolean isAllServerIds() {
        return allServerIds;
    }

    public final void setAllServerIds(boolean allServerIds) {
        if (lastAllServerIds == 0) {
            lastAllServerIds = this.allServerIds ? 1 : -1;
        }

        this.allServerIds = allServerIds;
    }

    public int getLastAllServerIds() {
        return lastAllServerIds;
    }

    public String[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String[] groupIds) {
        if (lastGroupIds == null) {
            lastGroupIds = groupIds == null ? KernelLang.NULL_STRINGS : groupIds;
        }

        this.groupIds = groupIds;
    }

    public String[] getLastGroupIds() {
        return lastGroupIds;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
