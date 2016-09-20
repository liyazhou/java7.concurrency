package chapter06.concurrent_collections.demo01.no_blocking_thread_safe_lists;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * ��ConcurrentLinkedDeque��ɾ��10000��Ԫ��
 */
public class PollTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }

}
