package com.norelax.www.springbootkafka.config;

import com.norelax.www.springbootkafka.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wusong
 * @date 2022年01月11日 18:30
 */
@Configuration
public class WebConfig {
    @Bean(initMethod = "init", destroyMethod = "destory")
    public User user() {
        return new User();
    }
}
