package com.norelax.www.springbootkafka.config;

import com.norelax.www.springbootkafka.entity.Book;
import com.norelax.www.springbootkafka.entity.Fish;
import com.norelax.www.springbootkafka.entity.MyBeanPostProcessor;
import com.norelax.www.springbootkafka.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wusong
 * @date 2022年01月11日 18:30
 */
@Configuration
public class WebConfig {
    @Bean
    public Book book() {
        return new Book();
    }

    @Bean(initMethod = "init", destroyMethod = "destory")
    public User user() {
        return new User();
    }

    @Bean
    public Fish fish() {
        return new Fish();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

}
