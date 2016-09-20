package me.liyazhou.java7.concurrency.ch2.demo06_modifyinglockfaireness;

/**
 * Created by liyazhou on 2015/7/7.
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s Going to print a doc\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s the doc has been printed\n", Thread.currentThread().getName());

    }
}
