package com.bolyartech.forge.server.module.user.data.user;

import com.bolyartech.forge.server.module.user.data.UserLoginType;

import java.sql.Connection;
import java.sql.SQLException;


public interface UserDbh {
    User loadById(Connection dbc, long id) throws SQLException;

    User createNew(Connection dbc, boolean isDisabled, UserLoginType lt) throws SQLException;

    boolean changeDisabled(Connection dbc, long id, boolean disabled) throws SQLException;

    User changeLoginType(Connection dbc, User user, UserLoginType lt) throws SQLException;

    boolean exists(Connection dbc, long id) throws SQLException;
}
