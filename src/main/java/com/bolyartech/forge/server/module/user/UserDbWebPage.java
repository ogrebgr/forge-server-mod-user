package com.bolyartech.forge.server.module.user;

import com.bolyartech.forge.server.db.DbPool;
import com.bolyartech.forge.server.handler.SecureDbWebPage;
import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import com.bolyartech.forge.server.route.RequestContext;

import java.sql.Connection;


abstract public class UserDbWebPage extends SecureDbWebPage {
    public UserDbWebPage(TemplateEngineFactory templateEngineFactory, DbPool dbPool) {
        super(templateEngineFactory, dbPool);
    }


    public UserDbWebPage(TemplateEngineFactory templateEngineFactory, boolean enableGzipSupport, DbPool dbPool) {
        super(templateEngineFactory, enableGzipSupport, dbPool);
    }


    @Override
    public String produceHtml(RequestContext ctx, TemplateEngine tple, Connection dbc) {
        return null;
    }
}
