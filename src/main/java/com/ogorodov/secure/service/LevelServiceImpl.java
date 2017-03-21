package com.ogorodov.secure.service;

import com.ogorodov.common.exceptions.LevelDaoException;
import com.ogorodov.common.exceptions.UserDaoException;
import com.ogorodov.common.exceptions.UserJdbcTemlateException;
import com.ogorodov.secure.entity.Level;
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
public class LevelServiceImpl implements LevelService {

    private static Logger logger = Logger.getLogger(LevelServiceImpl.class);

    private static String SQL_FIND_LEVEL = "SELECT access FROM levels, users WHERE users.accesslevel = levels.id AND " +
            "users.id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class LevelRowMapper implements RowMapper<Level> {
        @Override
        public Level mapRow(ResultSet rs, int rowNum) throws SQLException {
            logger.debug("LevelRowMapper");
            Level level = new Level(rs.getString("access"));
            return level;
        }
    }

    public String getUserAccessById(int id){
        logger.debug("getAllUsers");
        String level = (jdbcTemplate.queryForObject(SQL_FIND_LEVEL, new LevelRowMapper(), id)).getAccess();
        logger.debug(level.length());
        return level;
    }
}
