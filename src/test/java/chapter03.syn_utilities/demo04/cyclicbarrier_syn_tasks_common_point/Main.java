package chapter03.syn_utilities.demo04.cyclicbarrier_syn_tasks_common_point;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {

		/*
         * ��ʼ����ά����, 10000��,ÿ��1000������(1000��),��������5
		 */
        final int ROWS = 10000;                    // ��
        final int NUMBERS = 1000;                // ��
        final int SEARCH = 5;                    // Ҫ���ҵ�����
        final int LINES_PARTICIPANT = 2000;        // ÿ��������Ҫ���������
        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);

        // ��ʼ��Results����
        Results results = new Results(ROWS);

        // ����Grouper����
        Grouper grouper = new Grouper(results);

        // ����CyclicBarrier����,����5��������,���������,CyclicBarrier��ִ��grouper����
        final int PARTICIPANTS = 5;    // ����������
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        // ��������ʼ��������5��Searcher����
        Searcher searchers[] = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock,
                    results, 5, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }

        System.out.printf("Main: The main thread has finished.\n");
    }

}
