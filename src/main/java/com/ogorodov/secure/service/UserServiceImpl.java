package com.ogorodov.secure.service;

import com.ogorodov.repository.UserRepository;
import com.ogorodov.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;


    public User getUser(String login) {
        logger.debug("getUserByLogin " + login);
        return userRepository.findByLogin(login);
    }

    /*public User getUserByLoginAndPassword(String login, String password) throws UserDaoException {
        logger.debug("getUserByLoginAndPassword " + login + " password " + password);
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_USER_LOGIN_PASS, new UserRowMapper(), login, password);
        } catch (EmptyResultDataAccessException e) {
            logger.debug(login + " " + password + " not found - getAuth - ");
            throw new UserJdbcTemlateException(1);
        }
        logger.debug("getUserByLoginAndPassword " + login + " password " + password);
        if (user != null) {
            logger.debug(login + " " + password + " found - getAuth - ");
        }
        return user;
    }*/

    public List<User> getAllUsers()  {
        logger.debug("getAllUsers");
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        logger.debug("get User by id");
        return userRepository.findById(id);
    }
}
