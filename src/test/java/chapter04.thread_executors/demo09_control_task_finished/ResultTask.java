package chapter04.thread_executors.demo09_control_task_finished;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * FutureTaskʵ����Runnable, Future<V>�����ӿ�
 * ����ExecutableTask��ִ��.������done()����,��������������
 */
public class ResultTask extends FutureTask<String> {
    private String name;

    public ResultTask(Callable<String> callable) {
        // ExecutableTask����
        super(callable);
        // ȡ��ExecutableTask���������
        this.name = ((ExecutableTask) callable).getName();
    }

    // ��һЩ�������
    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been cancelled\n", name);
        } else {
            System.out.printf("%s: Has finished\n", name);
        }
    }

}
