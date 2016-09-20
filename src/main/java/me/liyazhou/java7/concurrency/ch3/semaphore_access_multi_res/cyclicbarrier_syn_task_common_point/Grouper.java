package me.liyazhou.java7.concurrency.ch3.semaphore_access_multi_res.cyclicbarrier_syn_task_common_point;

/**
 * Created by liyazhou on 2015/8/12.
 */
public class Grouper implements Runnable {
    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        int data[] = results.getData();
        for (int num : data) {
            finalResult += num;
        }
        System.out.printf("Grouper total result: %d.\n", finalResult);
    }
}
