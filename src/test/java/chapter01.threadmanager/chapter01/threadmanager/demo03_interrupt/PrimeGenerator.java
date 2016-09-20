package chapter01.threadmanager.chapter01.threadmanager.demo03_interrupt;

public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;

        // ѭ��(Ҳ��Ϊ��·��bucle)��Զ������ֱֹ�������ж�
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number % d is Prime\n", number);
            }

            // ������ж�,��ӡ��ϢȻ�����
            if (isInterrupted()) {
                // ��Ȼ���ж�,�����̵߳�״̬ΪRUNNABLE
                System.out.println("PrimeGenerator status��" + getState());
                System.out.println("The Prime Generator has been Interrupted\n");
                // �̱߳��жϲ���ʾ�߳���ֹ����,����������return���ע�͵�,�̻߳��ǻ����ִ��
                return;
            }

            number++;
        }
    }


    // �Ƿ�Ϊ����
    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }

        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }

        return true;
    }
}

