package com.example.service;

import com.example.model.User;
import com.example.model.UserBind;

/**
 * Created by zhan005 on 2016-03-18. Time:11:48 desc:
 */
public interface ExampleService {
    User get(String mixMobile);
    int save(User user);
    int updateSave(User user);

    UserBind getBindUser(int userId);
    int saveBindUser(UserBind userBind);
    int delBindUser(UserBind userBind);
    String pullOrder();
//    String syncMember();
}
