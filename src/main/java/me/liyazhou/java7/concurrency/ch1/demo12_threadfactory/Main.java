package me.liyazhou.java7.concurrency.ch1.demo12_threadfactory;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        System.out.printf("threads start\n");
        Thread thread;
        for (int i = 0; i < 5; i++) {
            thread = factory.newThread(task);
            thread.start();
        }
        System.out.printf("fatory stats:\n");
        System.out.printf("%s\n", factory.getStats());
    }
}
