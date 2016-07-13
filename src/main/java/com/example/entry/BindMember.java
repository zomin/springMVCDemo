package com.example.entry;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Kalend Zhang on 2016/07/11,011 .
 */



public class BindMember extends Member {
    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
