package me.liyazhou.java7.concurrency.ch2.demo05_syndataaccesswithreadwritelock;

/**
 * Created by liyazhou on 2015/7/7.
 */
public class Reader implements Runnable {
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.printf("%s get price1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
            System.out.printf("%s get price2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }
}
