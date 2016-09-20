package me.liyazhou.java7.concurrency.ch1.demo09_threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/2.
 */
public class Main2 {
    public static void main(String[] args) {
        SafeTask safeTask = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(safeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
