package com.fm.springmock

import com.fm.springmock.dao.SomeDAO
import com.fm.springmock.service.SomeService
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.annotation.Resource

/**
 * @author footmanff on 2018/11/8.
 */
@SpringBootTest
class Test1 extends Specification {

    @Resource
    SomeService someService

    @Resource
    SomeDAO someDAO

    /**
     * 是不是会受BaseTest里的配置影响，导致注入的SomeDAO是mock对象
     * 
     * 然而不是mock对象
     */
    def "base test"() {
        when:
        someService.doSome()

        then:
        1 == 1
    }

}
