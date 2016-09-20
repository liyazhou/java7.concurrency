package me.liyazhou.java7.concurrency.ch5.demo05.cancel_task;

import java.util.Random;

public class ArrayGenerator {
    public int[] generateArray(int size) {
        int array[] = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
