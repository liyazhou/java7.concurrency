package me.liyazhou.java7.concurrency.ch1.demo10_threadgroup;

import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class Main {
    public static void main(String[] args) {
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        ThreadGroup threadGroup = new ThreadGroup("Search");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("number of threads: %d\n", threadGroup.activeCount());
        System.out.printf("information about the thread group\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
        waitFinish(threadGroup);
        threadGroup.interrupt();
    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
