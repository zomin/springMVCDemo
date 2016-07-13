package com.example.entry;
/**
 * Created by Kalend Zhang on 2016/07/11,011 .
 */

public class BindResponse {
    private String success;
    private String bind_code;
    private String error_code;
    private BindMember member;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getBind_code() {
        return bind_code;
    }

    public void setBind_code(String bind_code) {
        this.bind_code = bind_code;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public BindMember getBindMember() {
        return member;
    }

    public void setBindMember(BindMember member) {
        this.member = member;
    }
}
