package com.norelax.www.springbootkafka.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author wusong
 * @date 2022年01月11日 18:35
 */
public class Book implements InitializingBean, DisposableBean {
    public Book() {
        System.out.println("调用无参构造器创建Bird");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁Bird");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化Bird");
    }
}
