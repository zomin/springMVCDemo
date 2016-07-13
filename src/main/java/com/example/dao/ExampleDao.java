package com.example.dao;

import com.example.model.User;
import com.example.model.UserBind;

/**
 * Created by zhan005 on 2016-03-18. Time:11:50 desc:
 */
public interface ExampleDao {
    User get(String mixMobile);
    int save(User user);

    int updateUser(User user);

    UserBind getBindUser(int userId);
    int saveBindUser(UserBind userBind);
    int delBindUser(UserBind userBind);

}
