package com.bolyartech.forge.server.module.user.endpoints;

import com.bolyartech.forge.server.handler.ForgeEndpoint;
import com.bolyartech.forge.server.module.user.SessionVars;
import com.bolyartech.forge.server.response.ResponseException;
import com.bolyartech.forge.server.response.forge.ForgeResponse;
import com.bolyartech.forge.server.response.forge.OkResponse;
import com.bolyartech.forge.server.route.RequestContext;
import com.bolyartech.forge.server.session.Session;


public class LogoutEp extends ForgeEndpoint {
    @Override
    public ForgeResponse handleForge(RequestContext ctx) throws ResponseException {
        Session session = ctx.getSession();
        session.setVar(SessionVars.VAR_USER, null);
        return new OkResponse();
    }
}
