package com.fm.core

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author zhangli on 2017/10/20.
 */
class SumTest extends Specification {

    def setup() {}          // run before every feature method
    def cleanup() {}        // run after every feature method
    def setupSpec() {}      // run before the first feature method
    def cleanupSpec() {}    // run after the last feature method

    def sum = new Sum()

    def "sum should return param1+param2"() {
        expect:
        sum.sum(1, 1) == 2
    }

    @Unroll
    def "maximum of #a and #b should be #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }

}
