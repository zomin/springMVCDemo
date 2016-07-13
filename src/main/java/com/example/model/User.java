package com.example.model;

import java.io.Serializable;

/**
 * Created by zhan005 on 2016-03-18. Time:11:56 desc:
 */
public class User implements Serializable{
    private static final String TAG = "User";

    private int userId;
    private int point;
    private int level;
    private String email;
    private String mobile;
    private String taobaoNick;
    private String mixMobile;
    private String mixUserId;

    public User() {

    }

    public User(int userId,int point, int level, String email, String mobile, String taobaoNick, String mixMobile, String mixUserId) {
        this.userId = userId;
        this.point = point;
        this.level = level;
        this.email = email;
        this.mobile = mobile;
        this.taobaoNick = taobaoNick;
        this.mixMobile = mixMobile;
        this.mixUserId = mixUserId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTaobaoNick() {
        return taobaoNick;
    }

    public void setTaobaoNick(String taobaoNick) {
        this.taobaoNick = taobaoNick;
    }

    public String getMixMobile() {
        return mixMobile;
    }

    public void setMixMobile(String mixMobile) {
        this.mixMobile = mixMobile;
    }

    public String getMixUserId() {
        return mixUserId;
    }

    public void setMixUserId(String mixUserId) {
        this.mixUserId = mixUserId;
    }
}