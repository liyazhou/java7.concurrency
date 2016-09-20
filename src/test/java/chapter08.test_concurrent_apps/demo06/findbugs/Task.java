package chapter08.test_concurrent_apps.demo06.findbugs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {
    private ReentrantLock lock;

    public Task(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();

        try {
            TimeUnit.SECONDS.sleep(1);
            /*
             * ��������н���������������.����߳������ߵ�ʱ���ж�.���������ͷ�,
			 * �����������ȴ��������߳�����.��Զ���������Ŀ���.
			 */
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
