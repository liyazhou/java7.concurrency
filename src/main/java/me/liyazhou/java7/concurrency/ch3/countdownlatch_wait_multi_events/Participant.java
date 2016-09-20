package me.liyazhou.java7.concurrency.ch3.countdownlatch_wait_multi_events;

import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/27.
 */
public class Participant implements Runnable {
    private Videoconference videoconference;
    private String name;

    public Participant(Videoconference videoconference, String name) {
        this.videoconference = videoconference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoconference.arrive(name);
    }
}
