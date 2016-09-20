package me.liyazhou.java7.concurrency.ch1.demo;

/**
 * Created by liyazhou on 2015/6/17.
 */
public class Calculator implements Runnable {
    private int number;
    public Calculator(int number){
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s:%d * %d = %d\n", Thread.currentThread().getName(), number, i,i * number);
        }
    }

}
