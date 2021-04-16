package com.ligaofei.domain;

public class User {
    private String name;

    public User(){
        System.out.println("User 空构造函数被调用");
    }
    public void init(){
        System.out.println("User类 init 方法被调用");
    }

    public void destroy(){
        System.out.println("User类 destroy 方法被调用");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
