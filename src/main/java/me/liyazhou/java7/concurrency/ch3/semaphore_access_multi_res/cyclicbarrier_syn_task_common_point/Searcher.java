package me.liyazhou.java7.concurrency.ch3.semaphore_access_multi_res.cyclicbarrier_syn_task_common_point;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by liyazhou on 2015/8/12.
 */
public class Searcher implements Runnable {
    private int firstrow;
    private int lastrow;
    private MatrixMock mock;
    private Results results;
    private int number;
    private final CyclicBarrier barrier;

    public Searcher(CyclicBarrier barrier, int number, Results results, MatrixMock mock, int lastrow, int firstrow) {
        this.barrier = barrier;
        this.number = number;
        this.results = results;
        this.mock = mock;
        this.lastrow = lastrow;
        this.firstrow = firstrow;
    }

    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processing lines: from %d to %d.\n", Thread.currentThread().getName(), firstrow, lastrow);
        for (int i = firstrow; i < lastrow; i++) {
            int row[] = mock.gerRow(i);
            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (number == row[j]) {
                    counter++;
                }
            }
            results.setData(i, counter);
        }
        System.out.printf("%s: lines processed.\n", Thread.currentThread().getName());

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
