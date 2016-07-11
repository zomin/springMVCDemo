package com.example.entry;
/**
 * Created by Kalend Zhang on 2016/07/11,011 .
 */

public class QueryRequest {
    private String seller_name;
    private String nick;
    private String mix_mobile;
    private String mobile;
    private String mix_nick;

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMix_mobile() {
        return mix_mobile;
    }

    public void setMix_mobile(String mix_mobile) {
        this.mix_mobile = mix_mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMix_nick() {
        return mix_nick;
    }

    public void setMix_nick(String mix_nick) {
        this.mix_nick = mix_nick;
    }
}
