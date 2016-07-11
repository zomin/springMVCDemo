package com.example.entry;
/**
 * Created by Kalend Zhang on 2016/07/11,011 .
 */

public class RegisterResponse {
    private String register_code;
    private Member member;

    public String getRegister_code() {
        return register_code;
    }

    public void setRegister_code(String register_code) {
        this.register_code = register_code;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
