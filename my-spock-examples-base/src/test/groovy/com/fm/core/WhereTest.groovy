package com.fm.core

import spock.lang.Specification

/**
 * @author footmanff on 2018/11/10.
 */
class WhereTest extends Specification {

    def "Name 1"() {
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


    def "Name"() {
        expect:
        a < b
        c < d

        where:
        a << [1, 1, 1]
        b << [2, 2, 2]
        c << [1, 1, 1]
        d << [2, 2, 2]
    }
}
