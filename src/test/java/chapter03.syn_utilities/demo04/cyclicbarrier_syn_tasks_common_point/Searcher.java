package chapter03.syn_utilities.demo04.cyclicbarrier_syn_tasks_common_point;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {

    /**
     * CyclicBarrier����ִ��
     */
    private final CyclicBarrier barrier;
    /**
     * ���ҵĵ�һ��
     */
    private int firstRow;
    /**
     * ���ҵ����һ��
     */
    private int lastRow;
    /**
     * ��ά����
     */
    private MatrixMock mock;
    /**
     * �洢���
     */
    private Results results;
    /**
     * Ҫ���ҵ�����
     */
    private int number;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int counter;    // ͳ��Ҫ���ҵ����ֳ��ֵĴ���
        System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);

        for (int i = firstRow; i < lastRow; i++) {
            int row[] = mock.getRow(i);    // ȡ��һ��
            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }

            results.setData(i, counter);    // ÿһ�г��ֶ��ٴ�
        }

        System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());

        try {
            //System.out.println("waiting number : " + barrier.getNumberWaiting());
            //System.out.println("await num : " + barrier.await());
            // �˷������ص�ǰ�̵߳�����,��0��ʼ.
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
