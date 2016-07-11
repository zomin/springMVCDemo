package com.example.controller;
/**
 * Created by Kalend Zhang on 2016/07/11,011 .
 */

import com.google.gson.Gson;

import com.example.entry.BindMember;
import com.example.entry.BindQueryResponse;
import com.example.entry.BindRequest;
import com.example.entry.BindResponse;
import com.example.entry.Member;
import com.example.entry.QueryRequest;
import com.example.entry.QueryResponse;
import com.example.entry.RegisterRequest;
import com.example.entry.RegisterResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/crm")
public class TmallExampleController {
    private static final String TAG = "TmallExampleController";
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TmallExampleController.class);
    private static final Gson gson = new Gson();

    @RequestMapping(value = "/register",method= RequestMethod.POST)
    @ResponseBody
    public String ExampleReg(@RequestBody String json){

        LOGGER.info(json);
        RegisterRequest registerRequest = gson.fromJson(json, RegisterRequest.class);

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setRegister_code("SUC");
        Member member = new Member();
        member.setLevel(1);
        member.setPoint(100);
        member.setMobile(registerRequest.getMix_mobile());
        registerResponse.setMember(member);
        String regJson = gson.toJson(registerResponse);

        return regJson;
    }


    @RequestMapping(value="/bindQuery",method= RequestMethod.POST)
    @ResponseBody
    public String ExampleBindQuery(@RequestBody String json){
        System.out.println(json);
        RegisterRequest registerRequest = gson.fromJson(json, RegisterRequest.class);
        BindQueryResponse bindQueryResponse = new BindQueryResponse();
        bindQueryResponse.setBindable(true);
        Member member = new Member();
        member.setLevel(1);
        member.setPoint(100);
        member.setMobile(registerRequest.getMix_mobile());
        bindQueryResponse.setMember(member);
        String regJson = gson.toJson(bindQueryResponse);

        return regJson;
    }

    @RequestMapping(value = "/bind",method= RequestMethod.POST)
    @ResponseBody
    public String ExampleBind(@RequestBody String json){
        System.out.println(json);
        BindRequest bindRequest = gson.fromJson(json, BindRequest.class);
        String type = bindRequest.getType();
        BindResponse bindResponse = new BindResponse();
        if("1".equals(type)){
            bindResponse.setBind_code("SUC");
            BindMember bindMember = new BindMember();
            bindMember.setMobile("12312312312");
            bindMember.setPoint(123);
            bindMember.setLevel(1);
            bindMember.setNick("asdsad");
            bindMember.setExtend("");
            bindResponse.setBindMember(bindMember);
        }else if("2".equals(type)){
            bindResponse.setBind_code("SUC");
            BindMember bindMember = new BindMember();
            bindMember.setMobile("12312312311");
            bindMember.setPoint(1234);
            bindMember.setLevel(1);
            bindMember.setNick("asdad");
            bindMember.setExtend("");
            bindResponse.setBindMember(bindMember);
        }
        String reqJson = gson.toJson(bindResponse);
        return reqJson;
    }

    @RequestMapping(value = "/query",method= RequestMethod.POST)
    @ResponseBody
    public String ExampleQuery(@RequestBody String json){
        System.out.println(json);
        QueryRequest queryRequest = gson.fromJson(json, QueryRequest.class);

        QueryResponse queryResponse = new QueryResponse();
        BindMember bindMember = new BindMember();
        bindMember.setNick("123213");
        bindMember.setExtend("");
        bindMember.setLevel(1);
        bindMember.setPoint(123);
        bindMember.setMobile("1231231221");
        queryResponse.setQuery_code("SUC");
        queryResponse.setBindMember(bindMember);

        String reqJson = gson.toJson(queryResponse);
        return reqJson;

    }
}
