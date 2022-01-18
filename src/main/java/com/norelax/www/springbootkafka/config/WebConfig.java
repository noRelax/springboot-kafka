package com.norelax.www.springbootkafka.config;

import com.norelax.www.springbootkafka.entity.Book;
import com.norelax.www.springbootkafka.entity.Fish;
import com.norelax.www.springbootkafka.entity.MyBeanPostProcessor;
import com.norelax.www.springbootkafka.entity.School;
import com.norelax.www.springbootkafka.entity.User;
import com.norelax.www.springbootkafka.entity.UserThreadFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

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
    @DependsOn("school")
    public Fish fish() {
        return new Fish();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

    @Bean
    public School school() {
        return new School();
    }

    @Bean
    public UserThreadFactory userThreadFactory(@Value("${thread.group-id}") String whatFeaturOfGroup) {
        return new UserThreadFactory(whatFeaturOfGroup);
    }

}
