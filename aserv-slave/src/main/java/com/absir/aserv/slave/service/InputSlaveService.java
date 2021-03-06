/**
 * Copyright 2015 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2015年11月16日 下午9:18:08
 */
package com.absir.aserv.slave.service;

import com.absir.aserv.init.InitBeanFactory;
import com.absir.bean.basis.Base;
import com.absir.bean.inject.value.Bean;
import com.absir.bean.inject.value.Inject;
import com.absir.bean.inject.value.InjectType;
import com.absir.client.ServerEnvironment;
import com.absir.client.helper.HelperEncrypt;
import com.absir.slave.InputSlaveAdapter;
import com.absir.slave.InputSlaveContext;

@Base
@Bean
public class InputSlaveService extends InputSlaveContext {

    @Inject(type = InjectType.Selectable)
    private ISlaveServerPort slaveServerPort;

    @Override
    public byte[] registerData(InputSlaveAdapter adapter, byte[] buffer) {
        String group = InitBeanFactory.ME.getAppCode() + '_' + adapter.getGroup();
        String registerKey = HelperEncrypt.encryptionMD5(adapter.getKey(), buffer) + ',' + group + ',' + ServerEnvironment.getStartTime() + ',' +
                InitBeanFactory.ME.getVersion() + ',' + InitBeanFactory.ME.getAppRoute() + ',' + InitBeanFactory.ME.getAppCode();
        if (slaveServerPort != null) {
            registerKey += "," + slaveServerPort.getServerPort();
        }

        return adapter.sendDataBytes(registerKey.getBytes(), false, false, 0, null);
    }

    public interface ISlaveServerPort {

        public int getServerPort();

    }

}
