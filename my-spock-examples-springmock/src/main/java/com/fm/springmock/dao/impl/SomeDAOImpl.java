package com.fm.springmock.dao.impl;

import com.fm.springmock.dao.SomeDAO;
import org.springframework.stereotype.Service;

/**
 * @author footmanff on 2018/11/8.
 */
@Service
public class SomeDAOImpl implements SomeDAO {

    @Override
    public String doSomeInDB() {
        System.out.println("doSomeInDB");
        return "doSomeInDB result";
    }
    
}
