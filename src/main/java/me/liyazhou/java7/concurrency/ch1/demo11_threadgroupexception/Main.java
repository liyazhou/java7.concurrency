package me.liyazhou.java7.concurrency.ch1.demo11_threadgroupexception;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        MyThreadGroup myThreadGroup = new MyThreadGroup("my group");
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(myThreadGroup, task);
            t.start();
        }


    }
}
