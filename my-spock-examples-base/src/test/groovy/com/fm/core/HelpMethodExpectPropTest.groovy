package com.fm.core

import spock.lang.Specification

/**
 * @author footmanff on 2018/11/10.
 */
class HelpMethodExpectPropTest extends Specification {

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
        row << [0]
        name << ["footmanff"]
        age << [1]
    }

    def "Name 2"() {
        when:
        User user = [name: "zl", age: 1]
        println user.getName()
        println user.getAge()
        
        then:
        1 == 1
    }

    def "Name 3"() {
        when:
        User user = user()
        println user.getName()
        println user.getAge()

        then:
        1 == 1
    }
    
    def user(){
        User user = new User()
        user.setAge(1)
        user.setName("footmanff")
        return user
    }
    
}
