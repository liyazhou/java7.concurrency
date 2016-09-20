package chapter04.thread_executors.demo03.callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        // �̶���Ŀ���̳߳�
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer number = new Integer(random.nextInt(10));
            FactorialCalculator calcutor = new FactorialCalculator(number);
            // �ύ����
            Future<Integer> result = executor.submit(calcutor);
            resultList.add(result);
        }

        // ѭ��, ����̳߳ص�״̬
        do {
            System.out.printf("Main: Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                // isDone()������true,˵���������
                System.out.printf("Main: Task %d: %s\n", i, result.isDone());
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());    // �ȴ��������

        System.out.printf("Main: Results\n");
        // ��Ϊ����Ҫ������ȡ���̷߳��صĽ��,��ô�ͱ���Ҫ�����е��̶߳�ִ�н����˲���ȡ�ý��
        // ����������Ҫwhileѭ�����ж��߳��Ƿ��Ѿ�ȫ������
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                // ȡ�÷��صĽ��
                // get()����������ֱ��call()����ִ�н��������ؽ��
                number = result.get();

                // �쳣
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Core: Task %d: %d\n", i, number);
        }

		/*
        * ����shutdown()����֮��,���߳̾����Ͻ�����,���̳߳ػ��������ֱ����������ִ����Ż�ֹͣ
        * ��������� shutdown()����,��ô�̳߳ػ�һֱ������ȥ,�Ա���ʱ����µ�����.(shutdown()������������)
        */
        executor.shutdown();
    }
}
