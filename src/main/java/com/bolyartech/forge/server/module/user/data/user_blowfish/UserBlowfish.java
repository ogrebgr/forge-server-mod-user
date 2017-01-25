package com.bolyartech.forge.server.module.user.data.user_blowfish;

import com.bolyartech.forge.server.module.user.data.user.User;
import com.bolyartech.forge.server.module.user.data.blowfish.Blowfish;


public final class UserBlowfish {
    private final User mUser;
    private final Blowfish mBlowfish;


    public UserBlowfish(User user, Blowfish blowfish) {
        mUser = user;
        mBlowfish = blowfish;
    }


    public User getUser() {
        return mUser;
    }


    public Blowfish getBlowfish() {
        return mBlowfish;
    }
}
