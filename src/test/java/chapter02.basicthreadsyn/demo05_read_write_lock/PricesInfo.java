package chapter02.basicthreadsyn.demo05_read_write_lock;

import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {

    // ���ּ۸�
    private double price1;
    private double price2;

    // ���Ƽ۸����
    private ReadWriteLock lock;

    public PricesInfo() {
        price1 = 1.0;
        price2 = 2.0;

        lock = new ReentrantReadWriteLock();
    }

    // ��õ�һ���۸�
    public double getPrice1() {
        // ��ȡread��
        lock.readLock().lock();

        // �Լ�����һЩ������Ϣ
        System.out.println("price1 ���read��   =====>");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = price1;
        System.out.println("price1 ���read��   <=====");

        lock.readLock().unlock();

        return value;
    }

    // ��õ�һ���۸�
    public double getPrice2() {
        // ��ȡread��
        lock.readLock().lock();

        System.out.println("price2 ���read��   =====>");    // �Լ��ӵĴ�ӡ���
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = price2;
        System.out.println("price2 ���read��   <=====");

        lock.readLock().unlock();

        return value;
    }

    // ���ü۸�
    public void setPrices(double price1, double price2) {
        // ���write��
        lock.writeLock().lock();
        System.out.println("���write�� at " + new Date());
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.price1 = price1;
        this.price2 = price2;

        System.out.println("�ͷ���           at " + new Date());
        lock.writeLock().unlock();
    }
}
