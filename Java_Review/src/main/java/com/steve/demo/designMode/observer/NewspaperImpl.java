package com.steve.demo.designMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: STEVE
 * @Description: 报纸接口Newspaper的实现类，维护了一个订阅者列表，当报纸到达时会通知所有订阅者。
 * @since: 2023/12/7
 */
public class NewspaperImpl implements Newspaper{

    // 订阅者集合
    List<Subscriber> subscribers = new ArrayList<>();

    /**
     * 添加订阅者
     * @param subscriber
     */
    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    /**
     * 移除订阅者
     * @param subscriber
     */
    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    /**
     * 通知订阅者
     * @param message
     */
    @Override
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}
