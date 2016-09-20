package me.liyazhou.java7.concurrency.ch3.semaphore_access_multi_res.cyclicbarrier_syn_task_common_point;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by liyazhou on 2015/8/12.
 */
public class Main {

    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT = 2000;

        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        Searcher[] searchers = new Searcher[PARTICIPANTS];
        for (int i = 0; i < searchers.length; i++) {
            searchers[i] = new Searcher(barrier, SEARCH, results, mock, (i + 1) * LINES_PARTICIPANT, i * LINES_PARTICIPANT);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.printf("Main: main thread has finished.\n");
    }
}
