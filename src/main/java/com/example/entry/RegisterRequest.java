package com.example.entry;
/**
 * Created by Kalend Zhang on 2016/07/11,011 .
 */

public class RegisterRequest {
    private String seller_name;
    private String mix_mobile;
    private String mix_user_id;
    private String taobao_nick;
    private String mobile;
    private String extend;

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getMix_mobile() {
        return mix_mobile;
    }

    public void setMix_mobile(String mix_mobile) {
        this.mix_mobile = mix_mobile;
    }

    public String getMix_user_id() {
        return mix_user_id;
    }

    public void setMix_user_id(String mix_user_id) {
        this.mix_user_id = mix_user_id;
    }

    public String getTaobao_nick() {
        return taobao_nick;
    }

    public void setTaobao_nick(String taobao_nick) {
        this.taobao_nick = taobao_nick;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
