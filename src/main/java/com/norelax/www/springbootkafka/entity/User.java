package com.norelax.www.springbootkafka.entity;

/**
 * @author wusong
 * @date 2022年01月11日 18:29
 */
public class User {
    public User() {
        System.out.println("调用无参构造器创建User");
    }

    public void init() {
        System.out.println("初始化User");
    }

    public void destory() {
        System.out.println("销毁User");
    }
}
