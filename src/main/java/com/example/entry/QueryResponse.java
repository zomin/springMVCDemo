package com.example.entry;
/**
 * Created by Kalend Zhang on 2016/07/11,011 .
 */

public class QueryResponse {
    private String query_code;
    private String success;
    private String error_code;
    private BindMember bindMember;

    public String getQuery_code() {
        return query_code;
    }

    public void setQuery_code(String query_code) {
        this.query_code = query_code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public BindMember getBindMember() {
        return bindMember;
    }

    public void setBindMember(BindMember bindMember) {
        this.bindMember = bindMember;
    }
}
