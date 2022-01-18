package com.norelax.www.springbootkafka.controller;

import com.norelax.www.springbootkafka.entity.Message;
import com.norelax.www.springbootkafka.entity.UserThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * kafka消息发送
 *
 * @author wusong
 * @create 2022-01-10 21:47
 **/
@Controller
@RequestMapping("/send")
@Slf4j
public class KafkaSendMessageController {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    @Autowired
    private UserThreadFactory userThreadFactory;

    @GetMapping("/{message}")
    @ResponseBody
    public String sendMessage(@PathVariable String message) {
        ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send("test", new Message("norelax", message));
        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("消息：{} 发送失败，原因：{}", message, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                log.info("成功发送消息：{}，offset=[{}]", message, result.getRecordMetadata().offset());
            }
        });
        return "OK";
    }

    @GetMapping("/thread")
    @ResponseBody
    public String thread() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 20, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000), userThreadFactory);
        executor.execute(() -> {
            log.info("ThreadPool method execute!");
        });
        executor.shutdown();
        return "OK";
    }

}
