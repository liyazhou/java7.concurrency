package chapter03.syn_utilities.demo02.semaphore_access_multi_res;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
    /**
     * �ź������ƴ�ӡ�ߵķ���
     */
    private Semaphore semaphore;
    /**
     * ���ƿ��д�ӡ�ߵ�����
     */
    private boolean freePrinters[];
    /**
     * ���Ʒ���freePrinters�������
     */
    private Lock lockPrinters;

    public PrintQueue() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document) {
        String name = Thread.currentThread().getName();
        try {
            // ��ȡ�ź���, ���׳�InterruptedException�쳣
            semaphore.acquire();

            System.out.println(name + " ����ź���  at : " + sdf.format(new Date()));

            // ȡ�ÿ��д�ӡ�ߵ���Ŀ
            int assignedPrinter = getPrinter();

            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", name,
                    assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);

            //
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + " �ͷ��ź���  at : " + sdf.format(new Date()) + "\r\n");

            semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;

        try {
            // ��ȡ��
            lockPrinters.lock();

            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }

        return ret;
    }
}
