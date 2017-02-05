package com.bolyartech.forge.server.module.user;

import com.bolyartech.forge.server.handler.SecureWebPage;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;


abstract public class UserWebPage extends SecureWebPage {
    public UserWebPage(TemplateEngineFactory templateEngineFactory, boolean enableGzipSupport) {
        super(templateEngineFactory, enableGzipSupport);
    }


    public UserWebPage(TemplateEngineFactory templateEngineFactory) {
        super(templateEngineFactory);
    }
}
