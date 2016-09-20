package chapter04.thread_executors.demo02_fixsize_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ģ��һ��������,����web������,�������� ʹ��ThreadPoolExecutorȥִ����Щ����
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        // �����̶���С���̳߳�
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        // ��Ҫִ�е��������Ŀ
        System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
