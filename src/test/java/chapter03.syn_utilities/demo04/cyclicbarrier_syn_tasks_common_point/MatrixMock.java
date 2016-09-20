package chapter03.syn_utilities.demo04.cyclicbarrier_syn_tasks_common_point;

import java.util.Random;

/**
 * ����1��10֮����������
 **/
public class MatrixMock {

    /**
     * ������Ķ�ά����
     */
    private int data[][];


    /**
     * ͳ��Ҫ���ҵ����ֳ��ֵ�����
     *
     * @param size   ���������
     * @param length ���������
     * @param number Ҫ���ҵ�����
     */
    public MatrixMock(int size, int length, int number) {
        int counter = 0;    // Ҫ���ҵ����ֵĸ���
        data = new int[size][length];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                // ͳ��Ҫ���ҵ����ֳ��ֵ�����
                if (data[i][j] == number) {
                    counter++;
                }
            }
        }

        System.out.printf("Mock: There are %d ocurrences of number in generated data.\n", counter, number);
    }

    /**
     * ���ض�ά�����һ��
     */
    public int[] getRow(int row) {
        if ((row >= 0) && (row < data.length)) {
            return data[row];
        }

        return null;
    }
}
