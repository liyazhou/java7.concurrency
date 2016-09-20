package me.liyazhou.java7.concurrency.ch3.semaphore_access_multi_res.cyclicbarrier_syn_task_common_point;

import java.util.Random;

/**
 * Created by liyazhou on 2015/8/12.
 */
public class MatrixMock {
    private int[][] data;

    public MatrixMock(int size, int length, int number) {
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextInt(10);
                if (data[i][j] == number) {
                    counter++;
                }
            }
        }
        System.out.printf("Mock: %d occurrences %d.\n", counter, number);
    }

    public int[] gerRow(int row) {
        if (row >= 0 && row < data.length) {
            return data[row];
        } else {
            return null;
        }

    }
}
