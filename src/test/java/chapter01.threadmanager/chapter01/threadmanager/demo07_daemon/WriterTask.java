package chapter01.threadmanager.chapter01.threadmanager.demo07_daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {
    // �洢�¼�
    Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an event	=> %s", Thread.currentThread().getId(), String.valueOf(event.getDate())));
            // ���е�����Ϊ��
            // event.setEvent(String.format("The thread %s has generated an event",Thread.currentThread().getId()));

            // ���뵽deque
            deque.addFirst(event);
            try {
                // ˯��1��
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
