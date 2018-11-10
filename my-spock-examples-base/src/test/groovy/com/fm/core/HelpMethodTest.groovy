package com.fm.core

import spock.lang.Specification

/**
 * @author footmanff on 2018/11/10.
 */
class HelpMethodTest extends Specification {

    def "Name"() {
        when:
        int a = 1
        
        then:
        method1(a)
        method3()
    }
    
    def method1(int a) {
        a > 0
    }

    def method2() {
        method3()
    }

    def method3() {
        1 > 0
    }
    
}
