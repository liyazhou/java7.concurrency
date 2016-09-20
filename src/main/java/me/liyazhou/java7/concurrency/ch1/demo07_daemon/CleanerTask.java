package me.liyazhou.java7.concurrency.ch1.demo07_daemon;

import java.util.Date;
import java.util.Deque;

/**
 * Created by liyazhou on 2015/7/1.
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        if (deque.isEmpty())
            return;
        boolean delete;
        long difference;
        delete = false;
        do {
            Event event = deque.getLast();
            difference = date.getTime() - event.getDate().getTime();
            if (difference > 10000) {
                deque.removeLast();
                System.out.printf("cleaner: %s\n", event.getEvent());
                delete = true;
            }
//        } while (difference > 10000);
        } while (difference > 10000 && !deque.isEmpty());
        if (delete) {
            System.out.printf("Cleaner: the size of the queue: %d\n", deque.size());
        }
    }
}
