package me.liyazhou.java7.concurrency.ch3.countdownlatch_wait_multi_events;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liyazhou on 2015/7/27.
 */
public class Videoconference implements Runnable {
    private final CountDownLatch controller;

    public Videoconference(int num) {
        controller = new CountDownLatch(num);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("videoconference: initialization: %d participants.\n", controller.getCount());
        try {
            controller.await();
            System.out.printf("all the participants have come, let's start....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
