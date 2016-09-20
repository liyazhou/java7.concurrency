package me.liyazhou.java7.concurrency.ch2.demo01_synchronized;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.addAmount(100);
        }
    }
}
