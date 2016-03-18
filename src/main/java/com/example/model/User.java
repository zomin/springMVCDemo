package com.example.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by zhan005 on 2016-03-18. Time:11:56 desc:
 */
public class User implements Serializable{
    private static final String TAG = "User";

    private Integer userSysId;
    private String userId;
    private String userEmail;
    private String userPassword;
    private Integer version;
    private String userStatus;
    private Date createTime;
    private Date updateTime;
    private String createOp;
    private String updateOp;
    private String userName;
    private String userRemark;

    public User() {

    }

    public User(Integer userSysId, String userId, String userEmail, String userPassword, Integer version, String userStatus, Date createTime, Date updateTime, String createOp, String updateOp, String userName, String userRemark) {
        this.userSysId = userSysId;
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.version = version;
        this.userStatus = userStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createOp = createOp;
        this.updateOp = updateOp;
        this.userName = userName;
        this.userRemark = userRemark;
    }

    public static String getTAG() {
        return TAG;
    }

    public Integer getUserSysId() {
        return userSysId;
    }

    public void setUserSysId(Integer userSysId) {
        this.userSysId = userSysId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateOp() {
        return createOp;
    }

    public void setCreateOp(String createOp) {
        this.createOp = createOp;
    }

    public String getUpdateOp() {
        return updateOp;
    }

    public void setUpdateOp(String updateOp) {
        this.updateOp = updateOp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userSysId=" + userSysId +
                ", userId='" + userId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", version=" + version +
                ", userStatus='" + userStatus + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createOp='" + createOp + '\'' +
                ", updateOp='" + updateOp + '\'' +
                ", userName='" + userName + '\'' +
                ", userRemark='" + userRemark + '\'' +
                '}';
    }
}