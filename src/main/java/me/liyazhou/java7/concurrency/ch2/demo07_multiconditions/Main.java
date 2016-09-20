package me.liyazhou.java7.concurrency.ch2.demo07_multiconditions;

/**
 * Created by liyazhou on 2015/7/10.
 */
public class Main {
    public static void main(String[] args) {
        FileMock fileMock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        Producer producer = new Producer(fileMock, buffer);
        Thread producerThread = new Thread(producer, "Producer");

        Consumer[] consumers = new Consumer[3];
        Thread[] consumerThreads = new Thread[3];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer(buffer);
            consumerThreads[i] = new Thread(consumers[i], "Consumer: ");
        }
        producerThread.start();
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i].start();
        }

    }
}
