package chapter06.concurrent_collections.demo01.no_blocking_thread_safe_lists;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        // ����ConcurrentLinkedDeque
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread threads[] = new Thread[100];

        // ����100������Ԫ�ص��߳�
        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);

        // �ȴ��߳̽���
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());

        // ����100��ɾ��Ԫ�ص��߳�
        for (int i = 0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d PollTask threads have been launched\n", threads.length);

        // �ȴ��߳̽���
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());
    }


    /**
     Main: 100 AddTask threads have been launched
     Main: Size of the List: 1000000
     Main: 100 PollTask threads have been launched
     Main: Size of the List: 0
     */
}
