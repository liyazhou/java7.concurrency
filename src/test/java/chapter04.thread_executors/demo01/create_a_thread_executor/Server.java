package chapter04.thread_executors.demo01.create_a_thread_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ģ��һ��������,����web������,�������� ʹ��ThreadPoolExecutorȥִ����Щ����
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        // ʵ�ʵ��߳���Ŀ
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        // ����ִ�е��������Ŀ
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
