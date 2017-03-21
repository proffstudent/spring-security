package com.ogorodov.secure.service;

import com.ogorodov.common.exceptions.LevelDaoException;
import com.ogorodov.common.exceptions.UserDaoException;
import com.ogorodov.secure.entity.Level;
import com.ogorodov.secure.entity.User;

import java.util.List;

public interface LevelService {
    public String getUserAccessById(int id);

}
