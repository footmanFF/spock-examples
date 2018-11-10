package com.fm.core

import spock.lang.Specification

/**
 * @author footmanff on 2018/11/10.
 */
class HelpMethodExpectTest extends Specification {

    def "Name"() {
        expect:
        List<User> userList = new ArrayList<>()
        User user = new User()
        user.setAge(1)
        user.setName("footmanff")
        userList.add(user)

        User u = userList.get(row)
        name == u.getName()
        age == u.getAge()

        where:
        row || name        | age
        0   || "footmanff" | 1
    }

    def "Name 2"() {
        expect:
        List<User> userList = new ArrayList<>()
        User user = new User()
        user.setAge(1)
        user.setName("footmanff")
        userList.add(user)

        u == userList.get(row)

        // 此处需要User覆盖equals和hashCode
        where:
        row || u
        0   || [name: 'footmanff', age: 1]
    }

}
