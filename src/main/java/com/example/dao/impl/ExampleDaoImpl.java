package com.example.dao.impl;

import com.example.dao.ExampleDao;
import com.example.model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhan005 on 2016-03-18. Time:11:50 desc:
 */
@Repository
public class ExampleDaoImpl implements ExampleDao {
    private static final String TAG = "ExampleDaoImpl";
    private final Logger LOG = LogManager.getLogger(TAG);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User get(String userId) {
        String sql = "select * from user where USER_ID = ?";
        final User user = new User();
        jdbcTemplate.query(sql,new Object[]{userId}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getString("USER_ID"));
                user.setUserEmail(resultSet.getString("USER_EMAIL"));
                user.setUserName(resultSet.getString("USER_NAME"));
            }
        });
        return user;
    }
}