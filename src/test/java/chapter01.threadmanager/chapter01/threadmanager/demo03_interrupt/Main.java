package chapter01.threadmanager.chapter01.threadmanager.demo03_interrupt;

import java.util.concurrent.TimeUnit;

// �߳��ж�
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread task = new PrimeGenerator();
        task.start();    // ����

        // �ȴ�5��
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // �ж�PrimeGenerator�߳�, ���ǲ�������ֹ�̵߳�ִ��
        task.interrupt();

        Thread.sleep(5000);
        System.out.println(task.getState());    // TERMINATED
        task.interrupt();    // ��������߳���ֹ��,�ٴε���interrupt()�ǲ����׳��쳣��
    }

}

