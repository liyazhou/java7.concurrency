package me.liyazhou.java7.concurrency.ch1.demo06_join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/1.
 */
public class DataSourcesLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("beginning data sources loading: %s\n", new Date());
        try {
//            TimeUnit.SECONDS.sleep(4);
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("data sources loading has finished: %s\n", new Date());
    }
}
