package com.ogorodov.secure.service;

import com.ogorodov.common.exceptions.UserDaoException;
import com.ogorodov.secure.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String login);
    User getUserByLoginAndPassword(String login, String password) throws UserDaoException;
    List<User> getAllUsers();
    public User getUserById(int id);

}
