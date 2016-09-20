package me.liyazhou.java7.concurrency.ch2.demo01_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class Account {
    private double balance;

    public synchronized void addAmount(double amount) {
        double tmp = balance;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
    }

    public synchronized void subtractAmount(double amount) {
        double tmp = balance;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
