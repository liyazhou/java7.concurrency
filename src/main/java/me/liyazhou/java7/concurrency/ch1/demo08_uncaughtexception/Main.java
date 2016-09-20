package me.liyazhou.java7.concurrency.ch1.demo08_uncaughtexception;

/**
 * Created by liyazhou on 2015/7/2.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
