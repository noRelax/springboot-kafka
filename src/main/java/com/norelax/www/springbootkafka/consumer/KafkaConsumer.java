package com.norelax.www.springbootkafka.consumer;

import com.norelax.www.springbootkafka.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * kafka消费者
 *
 * @author wusong
 * @create 2022-01-10 22:03
 **/
//@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(groupId = "test-consumer",
            topicPartitions = @TopicPartition(topic = "test", partitions = {"0", "1"}))
    public void listen(Message message,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("接收消息: {},partition:{}", message, partition);
    }

}
