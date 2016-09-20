package me.liyazhou.java7.concurrency.ch2.demo01_synchronized;

/**
 * Created by liyazhou on 2015/7/3.
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(100);
        Company company = new Company(account);
        Bank bank = new Bank(account);

        Thread t1 = new Thread(company);
        Thread t2 = new Thread(bank);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.printf("Account Final: %f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
