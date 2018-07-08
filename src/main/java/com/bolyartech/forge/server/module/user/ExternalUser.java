package com.bolyartech.forge.server.module.user;

public class ExternalUser {
    private final String externalId;
    private final String email;


    public ExternalUser(String externalId, String email) {
        this.externalId = externalId;
        this.email = email;
    }


    public String getExternalId() {
        return externalId;
    }


    public String getEmail() {
        return email;
    }
}
