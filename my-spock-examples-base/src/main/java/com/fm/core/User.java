package com.fm.core;

/**
 * @author zhangli on 2017/10/20.
 */
public class User {

    private String name;
    private int age;

    public void methodThrowExp(){
        throw new RuntimeException();
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

}
