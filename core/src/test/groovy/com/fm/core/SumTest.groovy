package com.fm.core

import spock.lang.Specification
import spock.lang.Unroll

import java.util.stream.Collectors

/**
 * @author zhangli on 2017/10/20.
 */
class SumTest extends Specification {

    def cleanup() {}        // run after every feature method
    def setupSpec() {}      // run before the first feature method
    def cleanupSpec() {}    // run after the last feature method

    def sum = new Sum()

    def book

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

    def "Name"() {
        List list = new ArrayList()
        list.add(1)
        list.add(2)
        list.add(0)
        list = list.stream().filter({ e -> e > 0 }).collect(Collectors.toList())
        println list
    }

    public static void main(String[] args) {
        List list = new ArrayList()
        list.add(1)
        list.add(2)
        list.add(0)
        list = list.stream().filter({ e -> e > 0 }).collect(Collectors.toList())
        println list
    
        Map map = list.stream().collect(Collectors.toMap({e -> e.toString()}, {e -> e}))
        println( map)
    }
}
