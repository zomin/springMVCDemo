package com.example.service.impl;

import com.example.dao.ProDao;
import com.example.model.Pro;
import com.example.service.ProService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhan005 on 2016/5/11.
 */
@Service
public class ProServiceImpl implements ProService {
    private static final String TAG = "ProServiceImpl";
    private static final Logger LOG = LogManager.getLogger(ProServiceImpl.class);


    @Autowired
    private ProDao proDao;

    @Override
    public Pro get(String sysId) {
        LOG.info(TAG);
        Pro pro = proDao.find(sysId);

        return pro;
    }
}
