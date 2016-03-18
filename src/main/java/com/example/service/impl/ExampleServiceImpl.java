package com.example.service.impl;

import com.example.dao.ExampleDao;
import com.example.model.User;
import com.example.service.ExampleService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhan005 on 2016-03-18. Time:11:49 desc:
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    private static final String TAG = "ExampleServiceImpl";
//    private static final Logger LOG = LogManager.getLogger(ExampleServiceImpl.class);

    @Autowired
    private ExampleDao exampleDao;

    @Override
    public User get(String userId) {
        return exampleDao.get(userId);
    }
}