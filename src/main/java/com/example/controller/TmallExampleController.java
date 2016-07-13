package com.example.controller;
/**
 * Created by Kalend Zhang on 2016/07/11,011 .
 */

import com.google.gson.Gson;

import com.example.entry.BindMember;
import com.example.entry.BindQueryResponse;
import com.example.entry.BindRequest;
import com.example.entry.BindResponse;
import com.example.entry.Extend;
import com.example.entry.Member;
import com.example.entry.QueryRequest;
import com.example.entry.QueryResponse;
import com.example.entry.RegisterRequest;
import com.example.entry.RegisterResponse;
import com.example.model.User;
import com.example.model.UserBind;
import com.example.service.ExampleService;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

@Controller
@RequestMapping("/crm")
public class TmallExampleController {
    private static final String TAG = "TmallExampleController";
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TmallExampleController.class);
    private static final Gson gson = new Gson();
    private static final String md5Key = "t26vJB";
    @Autowired
    private ExampleService exampleService;

    @RequestMapping(value = "/register",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExampleReg(@RequestBody String json){
        System.out.println("ExampleReg Begin:"+json);
        RegisterResponse registerResponse = new RegisterResponse();
        try{
            RegisterRequest registerRequest = gson.fromJson(json, RegisterRequest.class);
            User user = new User();
            user.setTaobaoNick(registerRequest.getTaobao_nick());
            user.setEmail("");
            user.setLevel(1);
            user.setPoint(10);
            user.setMobile(registerRequest.getMobile());
            user.setMixUserId(registerRequest.getMix_user_id());
            user.setMixMobile(registerRequest.getMix_mobile());


            int i = exampleService.save(user);

            if(i>0){
                User userSaved = exampleService.get(registerRequest.getMix_mobile());
                UserBind userBind = new UserBind();
                userBind.setUserId(userSaved.getUserId());
                userBind.setSellerNick(registerRequest.getSeller_name());

                int count = exampleService.saveBindUser(userBind);
                if(count>0){
                    registerResponse.setRegister_code("SUC");
                    Member member = new Member();
                    member.setLevel(user.getLevel());
                    member.setPoint(user.getPoint());
                    member.setMobile(user.getMobile());
                    registerResponse.setMember(member);
                } else {
                    registerResponse.setRegister_code("E01");
                    Member member = new Member();
                    registerResponse.setMember(member);
                }

            }else {
                registerResponse.setRegister_code("E01");
                Member member = new Member();
                registerResponse.setMember(member);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            registerResponse.setRegister_code("E05");
            Member member = new Member();
            registerResponse.setMember(member);
        }

        String regJson = gson.toJson(registerResponse);
        System.out.println("ExampleReg End:"+regJson);
        return regJson;
    }


    @RequestMapping(value="/bindQuery",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExampleBindQuery(@RequestBody String json){
        System.out.println("ExampleBindQuery Begin:"+json);
        RegisterRequest registerRequest = gson.fromJson(json, RegisterRequest.class);
        BindQueryResponse bindQueryResponse = new BindQueryResponse();
        try{
            User user = exampleService.get(registerRequest.getMix_mobile());
            UserBind userBind = exampleService.getBindUser(user.getUserId());
            if(0 == user.getUserId()){
                bindQueryResponse.setBindable(false);
                bindQueryResponse.setBind_code("E04");
                Member member = new Member();
                bindQueryResponse.setMember(member);
            } else {
                if(0 == userBind.getUserBindId()){
                    bindQueryResponse.setBindable(true);
                    bindQueryResponse.setBind_code("");
                    Member member = new Member();
                    member.setMobile(user.getMobile());
                    member.setPoint(user.getPoint());
                    member.setLevel(user.getLevel());
                    Extend extend = new Extend();
                    extend.setEmail(user.getEmail());
                    extend.setHeadImg("");
                    member.setExtend(extend);
                    bindQueryResponse.setMember(member);
                }else{
                    bindQueryResponse.setBindable(false);
                    bindQueryResponse.setBind_code("E02");
                    Member member = new Member();
                    member.setMobile(user.getMobile());
                    member.setPoint(user.getPoint());
                    member.setLevel(user.getLevel());
                    Extend extend = new Extend();
                    extend.setEmail(user.getEmail());
                    extend.setHeadImg("");
                    member.setExtend(extend);
                    bindQueryResponse.setMember(member);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            bindQueryResponse.setBindable(false);
            bindQueryResponse.setBind_code("E05");
        }



        String regJson = gson.toJson(bindQueryResponse);
        System.out.println("ExampleBindQuery End:"+regJson);
        return regJson;
    }

    @RequestMapping(value = "/bind",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExampleBind(@RequestBody String json){
        System.out.println("ExampleBind Begin:"+json);
        BindRequest bindRequest = gson.fromJson(json, BindRequest.class);
        BindResponse bindResponse = new BindResponse();
        try{
            String type = bindRequest.getType();

            String mix_mobile = DigestUtils.md5Hex(md5Hex("tmall"+bindRequest.getMobile()+md5Key));
            System.out.println("ExampleBind mix_mobile:"+mix_mobile);
            User user = exampleService.get(mix_mobile);
            if("1".equals(type)){
                System.out.println("ExampleBind type:1");
                UserBind userBind= new UserBind();
                userBind.setUserId(user.getUserId());
                userBind.setSellerNick(bindRequest.getSeller_name());
                user.setMobile(bindRequest.getMobile());
                user.setTaobaoNick(bindRequest.getTaobao_nick());

                int i = exampleService.saveBindUser(userBind);
                System.out.println("ExampleBind save:"+i);
                if(i>0){
                    exampleService.updateSave(user);
                    bindResponse.setBind_code("SUC");
                } else {
                    bindResponse.setBind_code("E01");
                }
                BindMember bindMember = new BindMember();
                bindMember.setMobile(user.getMobile());
                bindMember.setPoint(user.getPoint());
                bindMember.setLevel(user.getLevel());
                bindMember.setNick(user.getTaobaoNick());
                Extend extend = new Extend();
                extend.setHeadImg("");
                extend.setEmail(user.getEmail());
                bindMember.setExtend(extend);
                bindResponse.setBindMember(bindMember);
            }else if("2".equals(type)){
                System.out.println("ExampleBind type:2");
                UserBind userBind = exampleService.getBindUser(user.getUserId());
                int i = exampleService.delBindUser(userBind);
                System.out.println("ExampleBind del:"+i);
                if(i>0){
                    bindResponse.setBind_code("SUC");
                    BindMember bindMember = new BindMember();
                    bindMember.setMobile(user.getMobile());
                    bindMember.setPoint(user.getPoint());
                    bindMember.setLevel(user.getLevel());
                    bindMember.setNick(user.getTaobaoNick());
                    Extend extend = new Extend();
                    extend.setHeadImg("");
                    extend.setEmail(user.getEmail());
                    bindMember.setExtend(extend);
                    bindResponse.setBindMember(bindMember);
                }else {
                    bindResponse.setBind_code("E01");
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            bindResponse.setBind_code("E01");
        }

        String reqJson = gson.toJson(bindResponse);
        System.out.println("ExampleBind End:"+reqJson);
        return reqJson;
    }

    @RequestMapping(value = "/query",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExampleQuery(@RequestBody String json){
        System.out.println("ExampleQuery Begin:"+json);
        QueryRequest queryRequest = gson.fromJson(json, QueryRequest.class);

        QueryResponse queryResponse = new QueryResponse();
        try{
            String mixMobile = queryRequest.getMix_mobile();
            if(StringUtils.isEmpty(queryRequest.getMix_mobile())){
                mixMobile = DigestUtils.md5Hex(md5Hex("tmall"+queryRequest.getMobile()+md5Key));
            }
            User user = exampleService.get(mixMobile);
            UserBind userBind = exampleService.getBindUser(user.getUserId());
            if(0 != user.getUserId()){
                if(0 != userBind.getUserBindId()){
                    queryResponse.setQuery_code("SUC");
                    BindMember bindMember = new BindMember();
                    bindMember.setNick(user.getTaobaoNick());
                    Extend extend = new Extend();
                    extend.setEmail(user.getEmail());
                    extend.setHeadImg("");
                    bindMember.setExtend(extend);
                    bindMember.setLevel(user.getLevel());
                    bindMember.setPoint(user.getPoint());
                    bindMember.setMobile(user.getMobile());
                    queryResponse.setBindMember(bindMember);
                }else {
                    queryResponse.setQuery_code("E02");
                    BindMember bindMember = new BindMember();
                    bindMember.setNick(user.getTaobaoNick());
                    Extend extend = new Extend();
                    extend.setEmail(user.getEmail());
                    extend.setHeadImg("");
                    bindMember.setExtend(extend);
                    bindMember.setLevel(user.getLevel());
                    bindMember.setPoint(user.getPoint());
                    bindMember.setMobile(user.getMobile());
                    queryResponse.setBindMember(bindMember);
                }

            } else {
                queryResponse.setQuery_code("E01");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            queryResponse.setQuery_code("E04");
        }

        String reqJson = gson.toJson(queryResponse);
        System.out.println("ExampleQuery End:"+reqJson);
        return reqJson;

    }
    @RequestMapping(value = "/pullOrder",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExamPullOrder(){
        System.out.println("ExamPullOrder Begin");
        String reqJson = exampleService.pullOrder();
        System.out.println("ExamPullOrder End:"+reqJson);
        return reqJson;
    }
}
