package com.steve.demo.designMode.observer;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/12/7
 */
public class Observer {

    public static void main(String[] args) {
        NewspaperImpl newspaper = new NewspaperImpl();
        SubscriberImpl li = new SubscriberImpl("李老头");
        SubscriberImpl wang = new SubscriberImpl("王奶奶");
        // 李老头和王奶奶订阅了报纸
        newspaper.addSubscriber(li);
        newspaper.addSubscriber(wang);
        // 报纸到了，通知订阅者
        newspaper.notifySubscribers("今天的报纸到了");
        // 李老头取消订阅了，移除
        newspaper.removeSubscriber(li);
        newspaper.notifySubscribers("明天的报纸还是这个点到！");
    }

}
