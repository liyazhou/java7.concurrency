package me.liyazhou.java7.concurrency.ch1.demo12_threadfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        this.name = name;
        counter = 0;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-thread_" + counter);
        counter++;
        stats.add(String.format("created thread %d with name %s on %s\n", thread.getId(), thread.getName(), new Date()));
        return thread;
    }

    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        Iterator iterator = stats.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
