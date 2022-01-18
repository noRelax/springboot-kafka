package com.norelax.www.springbootkafka.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * @author wusong
 * @date 2022年01月17日 10:24
 */
@Data
@Slf4j
public class School {
    private String name;
    private String address;

    public School() {
        log.info("school无参构造初始化！");
    }

    @PostConstruct
    public void init() {
        log.info("school init初始化！");
    }
}
