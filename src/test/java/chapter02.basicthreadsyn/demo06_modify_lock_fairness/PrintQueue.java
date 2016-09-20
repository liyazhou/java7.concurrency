package chapter02.basicthreadsyn.demo06_modify_lock_fairness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    /**
     * ʹ��true��false����
     */
    private final Lock queueLock = new ReentrantLock(true);
//	private final Lock queueLock = new ReentrantLock(false);

    public void printJob(Object document) {
        // 9���̵߳ȴ���
        queueLock.lock();

        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds in first  code block\n", Thread.currentThread().getName(),
                    (duration / 1000));

//			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
//                    (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        // ������Ĵ���һ��
        // 10���̵߳ȴ���
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds in second code block\n", Thread.currentThread().getName(),
                    (duration / 1000));

//			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
//                    (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }

}
