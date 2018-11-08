package com.fm.springmock.service.impl;

import com.fm.springmock.dao.SomeDAO;
import com.fm.springmock.service.SomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author footmanff on 2018/11/8.
 */
@Service
public class SomeServiceImpl implements SomeService {

    @Resource
    private SomeDAO someDAO;
    
    @Override
    public void doSome() {
        String result = someDAO.doSomeInDB();
        System.out.println("dosome result: [" + result + "]");
    }
}
