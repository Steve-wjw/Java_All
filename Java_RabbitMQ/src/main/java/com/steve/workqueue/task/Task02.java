package com.steve.workqueue.task;

import com.rabbitmq.client.Channel;
import com.steve.workqueue.utils.RabbitMqUtils;

import java.util.Scanner;

/**
 * @Author: STEVE
 * @Description: 发送线程
 * @since: 2023/12/29
 */
public class Task02 {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        try (Channel channel = RabbitMqUtils.getChannel();) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //从控制台当中接受信息
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入消息：");
            while (scanner.hasNext()) {
                String message = scanner.next();
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
                System.out.println("发送消息完成:" + message);
            }
        }
    }

}
