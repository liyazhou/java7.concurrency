package me.liyazhou.java7.concurrency.ch1.demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/6/18.
 */
public class FileClock implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("%s\n", "fileclock thread has been ended");
//                break;
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new FileClock());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
