package com.ogorodov.secure.service;

import com.ogorodov.common.exceptions.UserDaoException;
import com.ogorodov.common.exceptions.UserJdbcTemlateException;
import com.ogorodov.secure.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private static final String SQL_FIND_USER_LOGIN_PASS = "SELECT * FROM  public.users " +
            "WHERE login = ? AND password = ?";
    private static final String SQL_FIND_USER_LOGIN = "SELECT * FROM  public.users " +
            "WHERE login = ?";

    private static String SQL_ALL_USERS = "SELECT * FROM public.users";

    private static String SQL_FIND_USER = "SELECT * FROM public.users WHERE id =?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(String login) {
        logger.debug("getUserByLogin " + login);
        User user = null;
        user = jdbcTemplate.queryForObject(SQL_FIND_USER_LOGIN, new UserRowMapper(), login);
        logger.debug("getUserByLoginAndPassword " + login + " password ");
        if (user != null) {
            logger.debug(login + " " + " found - getAuth - ");
        }
        return user;
    }

    public User getUserByLoginAndPassword(String login, String password) throws UserDaoException {
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
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            logger.debug("UserRowMapper");
            User user = new User(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getDate("createdAt"),
                    rs.getDate("updatedAt"),
                    rs.getBoolean("enabled"),
                    rs.getString("sex"),
                    rs.getDate("birth"),
                    rs.getString("residence"),
                    rs.getString("education"),
                    rs.getString("workplace"),
                    rs.getString("position"),
                    rs.getString("passport"),
                    rs.getString("issuedBy"),
                    rs.getString("adrressReg"),
                    rs.getInt("accessLevel"));
            return user;
        }
    }

    public List<User> getAllUsers()  {
        logger.debug("getAllUsers");
        List<User> users = this.jdbcTemplate.query(SQL_ALL_USERS, new UserRowMapper());
        logger.debug(users.size());
        return users;
    }

    public User getUserById(int id) {
        logger.debug("getUserById " + id);
        User user = null;
        user = jdbcTemplate.queryForObject(SQL_FIND_USER, new UserRowMapper(), id);
        return user;
    }
}
