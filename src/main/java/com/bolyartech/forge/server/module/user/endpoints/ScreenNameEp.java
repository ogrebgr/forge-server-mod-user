package com.bolyartech.forge.server.module.user.endpoints;

import com.bolyartech.forge.server.db.DbPool;
import com.bolyartech.forge.server.module.user.ForgeUserDbEndpoint;
import com.bolyartech.forge.server.module.user.UserResponseCodes;
import com.bolyartech.forge.server.module.user.data.screen_name.ScreenName;
import com.bolyartech.forge.server.module.user.data.screen_name.ScreenNameDbh;
import com.bolyartech.forge.server.module.user.data.user.User;
import com.bolyartech.forge.server.response.ResponseException;
import com.bolyartech.forge.server.response.forge.ForgeResponse;
import com.bolyartech.forge.server.response.forge.MissingParametersResponse;
import com.bolyartech.forge.server.response.forge.OkResponse;
import com.bolyartech.forge.server.route.RequestContext;
import com.google.common.base.Strings;

import java.sql.Connection;
import java.sql.SQLException;


public class ScreenNameEp extends ForgeUserDbEndpoint {
    static final String PARAM_SCREEN_NAME = "screen_name";


    private final ScreenNameDbh screenNameDbh;


    public ScreenNameEp(DbPool dbPool, ScreenNameDbh screenNameDbh) {
        super(dbPool);
        this.screenNameDbh = screenNameDbh;
    }


    @Override
    public ForgeResponse handle(RequestContext ctx,
                                Connection dbc, User user) throws ResponseException, SQLException {

        String screenName = ctx.getFromPost(PARAM_SCREEN_NAME);
        if (Strings.isNullOrEmpty(screenName)) {
            return MissingParametersResponse.getInstance();
        }

        ScreenName existing = screenNameDbh.loadByUser(dbc, user.getId());
        if (existing != null) {
            return new ForgeResponse(UserResponseCodes.Errors.SCREEN_NAME_CHANGE_NOT_SUPPORTED, "Password too short");
        }

        if (!ScreenName.isValid(screenName)) {
            return new ForgeResponse(UserResponseCodes.Errors.INVALID_SCREEN_NAME, "Invalid screen name");
        }

        ScreenName sn = screenNameDbh.createNew(dbc, user.getId(), screenName);
        if (sn != null) {
            return new OkResponse();
        } else {
            return new ForgeResponse(UserResponseCodes.Errors.SCREEN_NAME_EXISTS, "Scree name already taken");
        }
    }
}
