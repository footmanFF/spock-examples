package com.fm.springmock.dao.impl;

import com.fm.springmock.dao.AnotherService;
import com.fm.springmock.dao.SomeDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author footmanff on 2018/11/9.
 */
@Service
public class AnotherServiceImpl implements AnotherService {
    
    @Resource
    private SomeDAO someDAO;

    @Override
    public void someMethod() {
        System.out.println("AnotherService call someMethod");    
    }
    
}
