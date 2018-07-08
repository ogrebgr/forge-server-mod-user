package com.bolyartech.forge.server.module.user.data.user;

import java.util.Objects;


public final class User {
    private static final int MIN_PASSWORD_LENGTH = 7;

    private final long id;
    private final boolean isDisabled;
    private final long loginType;


    public User(long id, boolean isDisabled, long loginType) {
        this.id = id;
        this.isDisabled = isDisabled;
        this.loginType = loginType;
    }


    public static boolean isValidUsername(String username) {
        return username.matches("^[\\p{L}][\\p{L}\\p{N} _]{1,48}[\\p{L}\\p{N}]$");
    }


    public static boolean isValidPasswordLength(String password) {
        if (password == null) {
            throw new IllegalArgumentException("password is null");
        }

        return password.length() >= MIN_PASSWORD_LENGTH;
    }


    public long getId() {
        return id;
    }


    public boolean isDisabled() {
        return isDisabled;
    }


    public long getLoginType() {
        return loginType;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof User) {
            User other = (User) obj;
            return other.getId() == id && other.isDisabled() == isDisabled && other.getLoginType() == loginType;
        } else {
            return false;
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, isDisabled, loginType);
    }

}
