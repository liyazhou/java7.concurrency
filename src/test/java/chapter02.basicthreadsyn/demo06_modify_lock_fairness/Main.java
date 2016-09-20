package chapter02.basicthreadsyn.demo06_modify_lock_fairness;

public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                // ÿ��0.1������һ���߳�
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
