package me.liyazhou.java7.concurrency.ch2.demo05_syndataaccesswithreadwritelock;

/**
 * Created by liyazhou on 2015/7/7.
 */
public class Main {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader[] readers = new Reader[5];
        Thread[] threadReaders = new Thread[5];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader(pricesInfo);
            threadReaders[i] = new Thread(readers[i]);
        }
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for (int i = 0; i < readers.length; i++) {
            threadReaders[i].start();
        }
        threadWriter.start();

    }
}
