package com.bolyartech.forge.server.module.user.google;

import com.bolyartech.forge.server.module.user.ExternalUser;


public interface GoogleSignInWrapper {
    ExternalUser checkToken(String token);
}
