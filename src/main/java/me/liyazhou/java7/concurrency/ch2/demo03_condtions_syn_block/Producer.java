package me.liyazhou.java7.concurrency.ch2.demo03_condtions_syn_block;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/6.
 */
public class Producer implements Runnable {
    private EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            eventStorage.set();
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
