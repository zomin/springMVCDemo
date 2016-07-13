package com.example.model;
/**
 * Created by Kalend Zhang on 2016/07/12,012 .
 */

public class UserBind {
    private int userBindId;
    private int userId;
    private String sellerNick;

    public UserBind() {
    }

    public UserBind(int userBindId, int userId, String sellerNick) {
        this.userBindId = userBindId;
        this.userId = userId;
        this.sellerNick = sellerNick;
    }

    public int getUserBindId() {
        return userBindId;
    }

    public void setUserBindId(int userBindId) {
        this.userBindId = userBindId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }
}
