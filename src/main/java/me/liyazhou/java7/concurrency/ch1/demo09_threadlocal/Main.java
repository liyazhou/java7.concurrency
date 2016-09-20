package me.liyazhou.java7.concurrency.ch1.demo09_threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/2.
 */
public class Main {
    public static void main(String[] args) {
        UnsafeTask unsafeTask = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(unsafeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
