package com.steve.combat.producerAndconsumer;

/**
 * @Author: STEVE
 * @Description: 消费者
 * @since: 2024/1/10
 */
public class Consumer extends Thread {

    private int num;
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void run() {
        storage.consume(num);
    }

}
