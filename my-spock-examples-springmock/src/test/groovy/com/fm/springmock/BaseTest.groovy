package com.fm.springmock

import com.fm.springmock.dao.SomeDAO
import com.fm.springmock.service.SomeService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import javax.annotation.Resource

/**
 * @author footmanff on 2018/11/8.
 */
@SpringBootTest
class BaseTest extends Specification {

    @Resource
    SomeService someService

    @Resource
    SomeDAO someDAO

    def "base test"() {
        given:
        someDAO.doSomeInDB() >> 'mock result'
        
        when:
        someService.doSome()

        then:
        1 == 1
    }

    @TestConfiguration
    static class MockConfig {
        def detachedMockFactory = new DetachedMockFactory()

        @Bean
        SomeDAO someDAO() {
            return detachedMockFactory.Mock(SomeDAO)
        }
    }

}
