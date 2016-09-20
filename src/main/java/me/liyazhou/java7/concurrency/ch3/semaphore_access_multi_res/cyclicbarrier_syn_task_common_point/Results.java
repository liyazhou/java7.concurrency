package me.liyazhou.java7.concurrency.ch3.semaphore_access_multi_res.cyclicbarrier_syn_task_common_point;

/**
 * Created by liyazhou on 2015/8/12.
 */
public class Results {
    private int data[];

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
