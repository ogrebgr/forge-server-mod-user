package com.bolyartech.forge.server.module.user.data.user_ext_id;

import com.bolyartech.forge.server.module.user.UserResponseCodes;

import java.util.HashMap;
import java.util.Map;


public final class UserExtId {
    public static final int TYPE_GOOGLE = 1;
    public static final int TYPE_FACEBOOK = 2;


    private final long id;
    private final long user;
    private final String extId;
    private final Type type;


    public UserExtId(long id, long user, String extId, Type type) {
        this.id = id;
        this.user = user;
        this.extId = extId;
        this.type = type;
    }


    public long getUser() {
        return user;
    }


    public Type getType() {
        return type;
    }


    public long getId() {
        return id;
    }


    public String getExtId() {
        return extId;
    }


    public enum Type {
        GOOGLE(1),
        FACEBOOK(2);

        private static final Map<Integer, UserResponseCodes.Errors> mTypesByValue = new HashMap<>();

        static {
            for (UserResponseCodes.Errors type : UserResponseCodes.Errors.values()) {
                mTypesByValue.put(type.getCode(), type);
            }
        }


        private final int mCode;


        Type(int code) {
            if (code > 0) {
                this.mCode = code;
            } else {
                throw new IllegalArgumentException("Code must be positive");
            }
        }


        public static UserResponseCodes.Errors fromInt(int code) {
            UserResponseCodes.Errors ret = mTypesByValue.get(code);
            if (ret != null) {
                return ret;
            } else {
                return null;
            }
        }


        public int getCode() {
            return mCode;
        }
    }
}
