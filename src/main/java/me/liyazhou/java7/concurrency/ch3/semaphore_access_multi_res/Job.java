package me.liyazhou.java7.concurrency.ch3.semaphore_access_multi_res;

/**
 * Created by liyazhou on 2015/7/21.
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: the document has been printed\n", Thread.currentThread().getName());
    }
}
