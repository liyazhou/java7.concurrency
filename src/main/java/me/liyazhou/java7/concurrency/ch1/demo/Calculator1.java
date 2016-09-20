package me.liyazhou.java7.concurrency.ch1.demo;

/**
 * Created by liyazhou on 2015/6/17.
 */
public class Calculator1 {
    public static void main(String [] args){
        for (int i = 0; i < 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
