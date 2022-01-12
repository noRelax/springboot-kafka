package com.norelax.www.springbootkafka.entity;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wusong
 * @date 2022年01月12日 09:24
 */
@Slf4j
public class Fish {
    public Fish() {
        log.info("fish无参构造初始化！");
    }

    @PostConstruct
    public void init() {
        log.info("fish init初始化！");
    }

    @PreDestroy
    public void destroy() {
        log.info("fish 销毁！");
    }
}
