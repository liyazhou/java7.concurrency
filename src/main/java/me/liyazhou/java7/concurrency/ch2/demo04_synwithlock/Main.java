package me.liyazhou.java7.concurrency.ch2.demo04_synwithlock;

/**
 * Created by liyazhou on 2015/7/7.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(printQueue));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
