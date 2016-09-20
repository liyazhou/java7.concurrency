package chapter06.concurrent_collections.demo01.no_blocking_thread_safe_lists;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * ����10000��Ԫ�ص�ConcurrentListDeque
 */
public class AddTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Element " + i);
        }
    }

}
