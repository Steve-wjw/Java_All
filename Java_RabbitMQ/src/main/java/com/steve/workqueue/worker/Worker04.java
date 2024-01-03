package com.steve.workqueue.worker;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.steve.workqueue.utils.RabbitMqUtils;
import com.steve.workqueue.utils.SleepUtils;

/**
 * @Author: STEVE
 * @Description: 工作线程4
 * @since: 2023/12/29
 */
public class Worker04 {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C4 等待接收消息处理时间较长");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String receivedMessage = new String(delivery.getBody());
            SleepUtils.sleep(30);
            System.out.println("接收到消息:" + receivedMessage);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息 false表示只应答接收到的那个传递的消息，true为应答所有消息包括传递过来的消息
             */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        // 采用手动应答
        boolean autoAck = false;
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        };
        channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback, cancelCallback);
    }

}
