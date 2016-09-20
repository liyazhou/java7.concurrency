package me.liyazhou.java7.concurrency.ch1.demo11_threadgroupexception;

import java.util.Random;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000 / ((int) random.nextDouble() * 100);
            System.out.printf("%s : %d\n", Thread.currentThread().getId(), result);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : interrupted\n");
                return;
            }
        }
    }
}
