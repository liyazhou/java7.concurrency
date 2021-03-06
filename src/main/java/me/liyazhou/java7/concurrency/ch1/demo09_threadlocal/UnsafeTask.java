package me.liyazhou.java7.concurrency.ch1.demo09_threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/2.
 */
public class UnsafeTask implements Runnable {
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("starting thread: %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("thread finished: %s : %s\n", Thread.currentThread().getId(), startDate);
    }
}
