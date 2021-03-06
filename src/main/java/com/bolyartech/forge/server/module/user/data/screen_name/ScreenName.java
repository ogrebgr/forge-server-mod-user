package com.bolyartech.forge.server.module.user.data.screen_name;

import com.google.common.base.Strings;

import java.util.Objects;


public final class ScreenName {
    private final long user;
    private final String screenName;


    public ScreenName(long user, String screenName) {
        if (user <= 0) {
            throw new IllegalArgumentException("user <= 0");
        }

        if (Strings.isNullOrEmpty(screenName)) {
            throw new IllegalArgumentException("screen name null or empty");
        }

        if (!isValid(screenName)) {
            throw new IllegalArgumentException("invalid screen name");
        }

        this.user = user;
        this.screenName = screenName;
    }


    public static boolean isValid(String screenName) {
        return screenName != null && screenName.matches("^[\\p{L}][\\p{L}\\p{N} ]{1,33}[\\p{L}\\p{N}]$");
    }


    public long getUser() {
        return user;
    }


    public String getScreenName() {
        return screenName;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ScreenName) {
            ScreenName other = (ScreenName) obj;

            return other.user == user && other.getScreenName().equals(screenName);
        } else {
            return false;
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(user, screenName);
    }
}
