package com.steve.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: STEVE
 * @Description: 简单生产
 * @since: 2023/12/18
 */
@RestController
@RequestMapping
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/kafka/normal/{message}")
    public void sendNormalMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("test", message);
    }

    @RequestMapping("/kafka/callbackOne/{message}")
    public void sendCallbackOneMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("test", message).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            // 成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                // 消息发送到的topic
                String topic = result.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = result.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = result.getRecordMetadata().offset();
                System.out.println("发送消息成功1:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            // 失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });
    }

    @RequestMapping("/kafka/callbackTwo/{message}")
    public void sendCallbackTwoMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("test", message).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败2："+ throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("发送消息成功2：" + result.getRecordMetadata().topic() + "-"
                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
            }
        });
    }

}
