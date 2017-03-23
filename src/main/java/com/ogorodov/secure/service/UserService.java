package com.ogorodov.secure.service;

import com.ogorodov.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String login);
    List<User> getAllUsers();
    User getUserById(Integer id);
}
