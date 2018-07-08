package com.bolyartech.forge.server.module.user.data;

public enum UserLoginType {
    UNKNOWN(-1),
    SCRAM(0),
    GOOGLE(1),
    FACEBOOK(2),
    BLOWFISH(3);

    private final long code;


    UserLoginType(long code) {
        this.code = code;
    }


    public static UserLoginType fromLong(long l) {
        if (l == 0) {
            return UserLoginType.SCRAM;
        }

        if (l == 1) {
            return UserLoginType.GOOGLE;
        }

        if (l == 2) {
            return UserLoginType.FACEBOOK;
        }

        return UserLoginType.UNKNOWN;
    }


    public long getCode() {
        return code;
    }
}
