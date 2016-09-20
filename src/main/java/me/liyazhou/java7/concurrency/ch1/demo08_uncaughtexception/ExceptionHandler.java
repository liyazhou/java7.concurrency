package me.liyazhou.java7.concurrency.ch1.demo08_uncaughtexception;


import java.lang.Thread.UncaughtExceptionHandler;

/**
 * Created by liyazhou on 2015/7/2.
 */
public class ExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("an exception \n");
        System.out.printf("Thread %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", t.getClass().getName(), e.getMessage());
        System.out.println("Stack Trace:");
        e.printStackTrace(System.out);
        System.out.printf("Status: %s\n", t.getState());
    }
}
