package com.bolyartech.forge.server.module.user.facebook;

import com.bolyartech.forge.server.module.user.ExternalUser;


public interface FacebookWrapper {
    ExternalUser checkToken(String token);
}
