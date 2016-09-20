package chapter02.basicthreadsyn.demo04_lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ģ���ӡ����
 * sleep������⣺http://www.javamex.com/tutorials/threads/sleep_issues.shtml
 */
public class PrintQueue {
    // ���Ʒ��ʶ��е���
    private final Lock queueLock = new ReentrantLock();
    //	private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");	// ��ú��뼶
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS.sss");    // ������뼶

    public void printJob(Object document) {
        // �õ��������ķ���
        queueLock.lock();
//		System.out.println("�����  at : " + new Date());

        System.out.println("�����  at : " + sdf.format(new Date()));

        try {
            long duration = (long) (Math.random() * 10000);
//			System.out.println((duration / 1000));
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds, sleep at %s \n", Thread.currentThread().getName(),
                    (duration / 1000), sdf.format(new Date()));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//			System.out.println("�ͷ���  at : " + new Date() + "\r\n");

            System.out.println("�ͷ���  at : " + sdf.format(new Date()) + "\r\n");

            queueLock.unlock();        // �ͷ���
        }
    }
}
