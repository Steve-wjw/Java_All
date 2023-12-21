package com.steve.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * @Author: STEVE
 * @Description: kafka消费者
 * @since: 2023/12/18
 */
@Component
public class KafkaConsumer {

    // 监听消费
    @KafkaListener(topics = {"test"})
    public void onNormalMessage(ConsumerRecord<String, Object> record) {
        System.out.println("简单消费：" + record.topic() + "-" + record.partition() + "=" + record.value());
    }

}
