package me.liyazhou.java7.concurrency.ch2.demo03_condtions_syn_block;

/**
 * Created by liyazhou on 2015/7/6.
 */
public class Main {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Thread producerThread = new Thread(new Producer(eventStorage));
        Thread consumerThread = new Thread(new Consumer(eventStorage));

        producerThread.start();
        consumerThread.start();
    }
}
