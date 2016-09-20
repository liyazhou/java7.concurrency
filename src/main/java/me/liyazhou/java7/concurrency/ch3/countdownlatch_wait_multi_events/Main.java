package me.liyazhou.java7.concurrency.ch3.countdownlatch_wait_multi_events;

/**
 * Created by liyazhou on 2015/7/27.
 */
public class Main {
    public static void main(String[] args) {
        Videoconference videoconference = new Videoconference(10);
        Thread thread = new Thread(videoconference);
        thread.start();
        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(videoconference, "Participant" + i);
            Thread thread1 = new Thread(participant);
            thread1.start();
        }
    }
}
