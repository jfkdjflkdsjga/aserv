package com.absir.aserv.developer;

import com.absir.aserv.configure.JConfigureUtils;
import com.absir.aserv.support.web.WebJetbrickSupply;
import com.absir.aserv.system.bean.JTplConfigure;
import com.absir.bean.core.BeanFactoryUtils;
import com.absir.bean.inject.value.Bean;
import com.absir.core.kernel.KernelLang;
import jetbrick.template.JetTemplate;

/**
 * Created by absir on 16/7/27.
 */
@Bean
public class Site implements KernelLang.GetTemplate<String, JetTemplate> {

    public static final Site ME = BeanFactoryUtils.get(Site.class);

    public static final JTplConfigure TPL = JConfigureUtils.getConfigure(JTplConfigure.class);

    @Override
    public JetTemplate getWith(String template) {
        return WebJetbrickSupply.getEngine().createTemplate(template);
    }

}