package chapter02.basicthreadsyn.demo07_multiconditions_lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �����ߺ������߹��������
 */
public class Buffer {
    // ����, �洢��������
    private LinkedList<String> buffer;

    // �������󳤶�
    private int maxSize;

    // ���Ʒ��ʻ������
    private ReentrantLock lock;

    // ���ƻ����Ƿ���һ�����ݺͿ��ÿռ������
    private Condition lines;
    private Condition space;

    // �������Ƿ�����
    private boolean pendingLines;

    public Buffer(int maxSize) {
        // ��ʼ������
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    /**
     * ����һ���ַ�������, ���Դ洢��buffer��
     */
    public void insert(String line) {
        // ȡ�����Ŀ���
        lock.lock();

        try {
            // ����������
            while (buffer.size() == maxSize) {
                // ע�⣺���õ���await()����. ���������Condition���. ��Ҫ��д��wait(), ����Object��ķ���
                // ��Ȼ��Ҳ������Condition�ķ���,��������Ҫע������������ֻ��1����ĸ������,���׸��
                // await()��Ӧ����signal()��signalAll()
                // ����await()�������Զ��ͷ����Ŀ���
                space.await();    // �ȴ����ÿռ�
                // �������һ���̵߳���signal()����signalAll()����,��������
            }

            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();    // ����lines.wait()��
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //
    public String get() {
        String line = null;
        lock.lock();
        try {
            while ((buffer.size() == 0) && hasPendingLines()) {
                lines.await();    // ��lines.signalAll()����
            }

            if (hasPendingLines()) {
                line = buffer.poll();
                System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return line;
    }

    /**
     * �������ߵ���, �����и����������
     */
    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    /**
     * �Ƿ��и����������Ҫ����
     */
    public boolean hasPendingLines() {
        return pendingLines || buffer.size() > 0;
    }
}
