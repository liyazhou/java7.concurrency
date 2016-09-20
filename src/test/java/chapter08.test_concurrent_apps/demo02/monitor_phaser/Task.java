package chapter08.test_concurrent_apps.demo02.monitor_phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    // ���������ÿ���׶����ߵ�ʱ��
    private int time;

    private Phaser phaser;

    public Task(int time, Phaser phaser) {
        this.time = time;
        this.phaser = phaser;
    }


    /**
     * ִ��3���׶�.��ÿ���׶�,����ָ����ʱ��.
     */
    @Override
    public void run() {
        /*
         * �ﵽphaser
		 */
        phaser.arrive();
		
		/*
		 * �׶�1
		 */
        System.out.printf("%s: Entering phase 1.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 1.\n", Thread.currentThread().getName());
		/*
		 * �׶�1����
		 */
        phaser.arriveAndAwaitAdvance();
		
		/*
		 * �׶�2
		 */
        System.out.printf("%s: Entering phase 2.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 2.\n", Thread.currentThread().getName());
		/*
		 * �׶�2����
		 */
        phaser.arriveAndAwaitAdvance();
		
		/*
		 * �׶�3
		 */
        System.out.printf("%s: Entering phase 3.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 3.\n", Thread.currentThread().getName());
		/*
		 * �׶�3����
		 */
        phaser.arriveAndDeregister();
    }

}

