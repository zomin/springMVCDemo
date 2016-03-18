package com.example.service;

import com.example.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhan005 on 2016-03-18. Time:12:15 desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class UserServiceTest {
    private static final String TAG = "UserServiceTest";

    @Autowired
    private ExampleService exampleService;

    @Test
    public void get(){
        User user = exampleService.get("1");
        System.out.println(user.toString());
    }
} 