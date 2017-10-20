package com.fm.core

import spock.lang.Specification

/**
 * @author zhangli on 2017/10/20.
 */
class UserTest extends Specification {

    def user = new User()

    def "methodThrowExp"() {
        when:
        user.methodThrowExp()
        then:
        // thrown(RuntimeException)
        def exp = thrown(RuntimeException)
    }

    def "SetName"() {
        when:
        user.setName("zl")

        then:
        user.getName() == "zl"
        assert user.name == "zl"
    }

    def "HashMap accepts null key"() {
        setup:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }

    def "bean test"() {
        expect:
        user2.getName() == param

        where:
        user2                 || param
        new User(name: "zl")  || "zl"
        new User(name: "fqj") || "fqj"
    }

    def sum = new Sum()

    def "sumAge"() {
        expect:
        sum.sumAge(user1, user2) == sumAge

        where:
        user1            | user2            || sumAge
        new User(age: 1) | new User(age: 1) || 2
        new User(age: 0) | new User(age: 0) || 0
    }

    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        // 按列赋给a, b, c
        a << [3, 5, 9]
        b << [7, 4, 9]
        c << [7, 5, 9]
    }

    def "maximum of two numbers2"() {
        expect:
        Math.max(a, b) == c

        where:
//        a = 3
//        b = Math.random() * 100
//        c = a > b ? a : b
        a << 3
        b << 4
        c << 4
    }
}
