package com.example.controller;

import com.example.model.User;
import com.example.service.ExampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhan005 on 2016-03-18. Time:11:46 desc:
 */
@Controller
public class ExampleController {
    private static final String TAG = "ExampleController";

    @Autowired
    private ExampleService exampleService;

    @RequestMapping("/login")
    public ModelAndView getUser(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getParameter("userId");
        User user = exampleService.get(userId);
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("user",user);
        return mv;
    }
} 