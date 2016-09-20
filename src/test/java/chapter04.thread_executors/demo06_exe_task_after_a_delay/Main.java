package chapter04.thread_executors.demo06_exe_task_after_a_delay;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // ����ScheduledExecutorService
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        System.out.printf("Main: Starting at: %s\n", new Date());

        // ��ָ�����ӳ�ʱ���������ִ����
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task-" + i);
            // schedule(Callable<V> callable, long delay, TimeUnit unit)
            executor.schedule(task, i + 1, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            // �ȴ�ִ���߽���,������
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Core: Ends at: %s\n", new Date());
    }
}
