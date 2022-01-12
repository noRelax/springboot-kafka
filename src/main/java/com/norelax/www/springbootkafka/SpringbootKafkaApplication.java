package com.norelax.www.springbootkafka;

import com.norelax.www.springbootkafka.config.WebConfig;
import com.norelax.www.springbootkafka.entity.Book;
import com.norelax.www.springbootkafka.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbootKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        context.close();
    }

}
