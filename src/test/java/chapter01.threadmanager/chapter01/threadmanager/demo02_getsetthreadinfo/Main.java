package chapter01.threadmanager.chapter01.threadmanager.demo02_getsetthreadinfo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

// FIXME��thread id
public class Main {

    public static void main(String[] args) {

        // �̵߳����ȼ���Ϣ
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

        Thread threads[];
        // �ڲ���ö����, ��ʾ�̵߳�״̬
        State status[];

        // ����10���߳�, 5������Ϊ������ȼ���, 5������Ϊ��С���� ����
        threads = new Thread[10];
        status = new State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0) {
                // �������ȼ�
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            // ��������
            threads[i].setName("Thread " + i);
        }

        // �ȴ��߳̽���, ͬʱ���̵߳�״̬��Ϣд�뵽�ļ���
        // �����õ�JDK7�е����﷨
        try (FileWriter file = new FileWriter("src/chapter01/threadmanager/demo02_getsetthreadinfo/log.txt");
             PrintWriter pw = new PrintWriter(file);) {

            // ��ʱ�̻߳�δ����
            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();    // ���̵߳�״̬�����status��, ��ʱ��״̬Ӧ��ΪNEW
            }

            // �����߳�
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    // ����,�߳�������(�п����������Ѿ���ֹ��),����threads[i].getState()��status[i](����NEW��״̬)�϶���ͬ
                    if (threads[i].getState() != status[i]) {
                        // ���߳���Ϣд�뵽�ļ���
                        // status[i] = NEW
                        writeThreadInfo(pw, threads[i], status[i]);
                        // ����״̬
                        status[i] = threads[i].getState();
                    }
                }

                finish = true;
                for (int i = 0; i < 10; i++) {
                    // �߳��Ƿ��Ѿ���ֹ
                    finish = finish && (threads[i].getState() == State.TERMINATED);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���̵߳���Ϣд�뵽�ļ���
     */
    private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }

}
