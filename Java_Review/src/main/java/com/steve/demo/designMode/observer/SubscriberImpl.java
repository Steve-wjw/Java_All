package com.steve.demo.designMode.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: STEVE
 * @Description: 订阅者接口的实现类，用于接收报纸到达的通知
 * @since: 2023/12/7
 */
@Data
@AllArgsConstructor
public class SubscriberImpl implements Subscriber {

    private String name;

    @Override
    public void update(String message) {
        System.out.println(name + "---接到消息：" + message);
    }

}
