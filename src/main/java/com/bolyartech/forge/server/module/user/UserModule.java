package com.bolyartech.forge.server.module.user;

import com.bolyartech.forge.server.db.DbPool;
import com.bolyartech.forge.server.module.HttpModule;
import com.bolyartech.forge.server.module.user.data.screen_name.ScreenNameDbh;
import com.bolyartech.forge.server.module.user.endpoints.LogoutEp;
import com.bolyartech.forge.server.module.user.endpoints.ScreenNameEp;
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
    private final ScreenNameDbh mScreenNameDbh;


    public UserModule(String pathPrefix,
                      DbPool dbPool,
                      ScreenNameDbh screenNameDbh
    ) {

        mPathPrefix = pathPrefix;
        mDbPool = dbPool;
        mScreenNameDbh = screenNameDbh;
    }


    public UserModule(
            DbPool dbPool,
            ScreenNameDbh screenNameDbh) {

        this(DEFAULT_PATH_PREFIX, dbPool,  screenNameDbh);
    }


    @Override
    public List<Route> createRoutes() {
        List<Route> ret = new ArrayList<>();

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
