package me.liyazhou.java7.concurrency.ch2.demo03_condtions_syn_block;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyazhou on 2015/7/6.
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                System.out.printf("get wait\n");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        ((LinkedList<Date>)storage).offer(new Date());
        storage.add(new Date());
        System.out.printf("Set %d\n", storage.size());
        notifyAll();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                System.out.printf("get wait\n");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s\n", storage.size(), ((LinkedList<?>) storage).poll());
        notifyAll();
    }

}
