package com.example.dao.impl;

import com.example.dao.ExampleDao;
import com.example.model.User;
import com.example.model.UserBind;

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
    public User get(String mixMobile) {
        String sql = "select * from user where mix_mobile = ?";
        User user = new User();
        jdbcTemplate.query(sql,new Object[]{mixMobile}, new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setTaobaoNick(resultSet.getString("taobao_nick"));
                    user.setMobile(resultSet.getString("mobile"));
                    user.setPoint(resultSet.getInt("point"));
                    user.setLevel(resultSet.getInt("level"));
                    user.setEmail(resultSet.getString("email"));
                    user.setMixMobile(resultSet.getString("mix_mobile"));
                    user.setMixUserId(resultSet.getString("mix_user_id"));
                }
        });
        return user;
    }

    @Override
    public int save(User user) {
        String sql = "insert into user(point,level,email,mobile,taobao_nick,mix_mobile,mix_user_id) values(?,?,?,?,?,?,?)";

        int count = jdbcTemplate.update(sql,new Object[]{user.getPoint(),user.getLevel(),user.getEmail(),user.getMobile(),user.getTaobaoNick(),user.getMixMobile(),user.getMixUserId()});

        return count;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set mobile=?, taobao_nick=? where user_id=?";

        int count = jdbcTemplate.update(sql,new Object[]{user.getMobile(),user.getTaobaoNick(),user.getUserId()});

        return count;
    }

    @Override
    public UserBind getBindUser(int userId) {
        String sql ="select * from bind_user where user_id = ?";
        UserBind userBind = new UserBind();
        jdbcTemplate.query(sql,new Object[]{userId},new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                userBind.setUserId(resultSet.getInt("user_id"));
                userBind.setSellerNick(resultSet.getString("seller_nick"));
                userBind.setUserBindId(resultSet.getInt("user_bind_id"));
            }
        });

        return userBind;
    }

    @Override
    public int saveBindUser(UserBind userBind) {
        String sql = "insert into bind_user(user_id, seller_nick) values(?,?)";
        int count = jdbcTemplate.update(sql,new Object[]{userBind.getUserId(),userBind.getSellerNick()});
        return count;
    }

    @Override
    public int delBindUser(UserBind userBind) {
        String sql = "delete from bind_user where user_bind_id = ?";
        int count = jdbcTemplate.update(sql,new Object[]{userBind.getUserBindId()});
        return count;
    }
}