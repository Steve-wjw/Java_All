package com.steve.combat.producerAndconsumer;

/**
 * @Author: STEVE
 * @Description: 生产者
 * @since: 2024/1/10
 */
public class Producer extends Thread {

    private int num;
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void run() {
        storage.produce(this.num);
    }

}
