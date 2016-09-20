package me.liyazhou.java7.concurrency.ch1.demo06_join;

import java.util.Date;

/**
 * Created by liyazhou on 2015/7/1.
 */
public class Main {
    public static void main(String[] args) {
        DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dataSourcesLoader, "dataSourcesLoader");
        thread1.start();
        NetworkConnectionsLoader networkConnectionsLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(networkConnectionsLoader, "networkConnectionsLoader");
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: configuration has been loaded: %s", new Date());
    }
}
