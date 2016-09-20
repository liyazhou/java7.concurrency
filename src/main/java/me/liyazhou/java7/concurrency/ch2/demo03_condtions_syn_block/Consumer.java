package me.liyazhou.java7.concurrency.ch2.demo03_condtions_syn_block;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/6.
 */
public class Consumer implements Runnable {
    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            eventStorage.get();
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
