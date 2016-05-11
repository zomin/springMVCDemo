package com.example.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by zhan005 on 2016/5/11.
 */
public class Pro implements Serializable {
    private static final String TAG = "Pro";

    private String userId;
    private String jsonString;
    private Date dataTime;
    private Integer flag;

    public Pro() {
    }

    public Pro(String userId, String jsonString, Date dataTime, Integer flag) {
        this.userId = userId;
        this.jsonString = jsonString;
        this.dataTime = dataTime;
        this.flag = flag;
    }

    public static String getTAG() {
        return TAG;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Pro{" +
                "userId='" + userId + '\'' +
                ", jsonString='" + jsonString + '\'' +
                ", dataTime=" + dataTime +
                ", flag=" + flag +
                '}';
    }
}
