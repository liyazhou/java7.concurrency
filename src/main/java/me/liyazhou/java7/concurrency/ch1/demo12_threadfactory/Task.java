package me.liyazhou.java7.concurrency.ch1.demo12_threadfactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
