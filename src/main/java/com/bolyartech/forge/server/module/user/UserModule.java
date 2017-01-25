package com.bolyartech.forge.server.module.user;

import com.bolyartech.forge.server.db.DbPool;
import com.bolyartech.forge.server.module.HttpModule;
import com.bolyartech.forge.server.module.user.data.user.UserDbh;
import com.bolyartech.forge.server.module.user.data.user_ext_id.UserExtIdDbh;
import com.bolyartech.forge.server.module.user.data.user_scram.UserScramDbh;
import com.bolyartech.forge.server.module.user.endpoints.LogoutEp;
import com.bolyartech.forge.server.module.user.endpoints.scram.AutoregistrationEp;
import com.bolyartech.forge.server.module.user.google.GoogleSignInWrapper;
import com.bolyartech.forge.server.module.user.data.scram.ScramDbh;
import com.bolyartech.forge.server.module.user.data.screen_name.ScreenNameDbh;
import com.bolyartech.forge.server.module.user.endpoints.ScreenNameEp;
import com.bolyartech.forge.server.module.user.endpoints.scram.LoginEp;
import com.bolyartech.forge.server.module.user.endpoints.scram.RegistrationEp;
import com.bolyartech.forge.server.module.user.endpoints.scram.RegistrationPostAutoEp;
import com.bolyartech.forge.server.route.PostRoute;
import com.bolyartech.forge.server.route.Route;

import java.util.ArrayList;
import java.util.List;


public final class UserModule implements HttpModule {
    private static final String DEFAULT_PATH_PREFIX = "/api/user/";

    private static final String MODULE_SYSTEM_NAME = "user";
    private static final int MODULE_VERSION_CODE = 1;
    private static final String MODULE_VERSION_NAME = "1.0.0";

    private final String mPathPrefix;
    private final DbPool mDbPool;
    private final UserScramDbh mUserScramDbh;
    private final UserDbh mUserDbh;
    private final ScramDbh mScramDbh;
    private final ScreenNameDbh mScreenNameDbh;
    private final UserExtIdDbh mUserExtIdDbh;


    public UserModule(String pathPrefix,
                      DbPool dbPool,
                      UserScramDbh userScramDbh,
                      UserDbh userDbh,
                      ScramDbh scramDbh,
                      ScreenNameDbh screenNameDbh,
                      UserExtIdDbh userExtIdDbh
    ) {

        mPathPrefix = pathPrefix;
        mDbPool = dbPool;
        mUserScramDbh = userScramDbh;
        mUserDbh = userDbh;
        mScramDbh = scramDbh;
        mScreenNameDbh = screenNameDbh;
        mUserExtIdDbh = userExtIdDbh;
    }


    public UserModule(
            DbPool dbPool,
            UserScramDbh userScramDbh,
            UserDbh userDbh,
            ScramDbh scramDbh,
            ScreenNameDbh screenNameDbh,
            UserExtIdDbh userExtIdDbh,
            GoogleSignInWrapper googleSignInWrapper) {

        this(DEFAULT_PATH_PREFIX, dbPool, userScramDbh, userDbh, scramDbh, screenNameDbh, userExtIdDbh);
    }


    @Override
    public List<Route> createRoutes() {
        List<Route> ret = new ArrayList<>();

        ret.add(new PostRoute(mPathPrefix + "autoregister",
                new AutoregistrationEp(mDbPool, mUserDbh, mScramDbh, mUserScramDbh)));
        ret.add(new PostRoute(mPathPrefix + "login",
                new LoginEp(mDbPool, mUserDbh, mScramDbh, mScreenNameDbh)));
        ret.add(new PostRoute(mPathPrefix + "register",
                new RegistrationEp(mDbPool, mUserDbh, mScramDbh, mUserScramDbh, mScreenNameDbh)));
        ret.add(new PostRoute(mPathPrefix + "register_postauto",
                new RegistrationPostAutoEp(mDbPool, mUserDbh, mScramDbh, mUserScramDbh, mScreenNameDbh)));
        ret.add(new PostRoute(mPathPrefix + "screen_name",
                new ScreenNameEp(mDbPool, mScreenNameDbh)));
        ret.add(new PostRoute(mPathPrefix + "logout",
                new LogoutEp()));


        return ret;
    }


    @Override
    public String getSystemName() {
        return MODULE_SYSTEM_NAME;
    }


    @Override
    public String getShortDescription() {
        return "";
    }


    @Override
    public int getVersionCode() {
        return MODULE_VERSION_CODE;
    }


    @Override
    public String getVersionName() {
        return MODULE_VERSION_NAME;
    }
}