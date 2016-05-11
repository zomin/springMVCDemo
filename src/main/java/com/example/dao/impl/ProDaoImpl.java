package com.example.dao.impl;

import com.example.dao.ProDao;
import com.example.model.Pro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhan005 on 2016/5/11.
 */
@Repository
public class ProDaoImpl implements ProDao {
    private static final String TAG = "ProDaoImpl";
    private final Logger LOG = LogManager.getLogger(TAG);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Pro find(String sysId) {
        String sql = "select * from Pro where userId=?";
        Pro pro = new Pro();
        jdbcTemplate.query(sql,new Object[]{sysId}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                pro.setUserId(resultSet.getString("userId"));
                pro.setJsonString(resultSet.getString("jsonString"));
                pro.setDataTime(resultSet.getDate("dataTime"));
                pro.setFlag(resultSet.getInt("flag"));
            }
        });
        return pro;
    }
}
