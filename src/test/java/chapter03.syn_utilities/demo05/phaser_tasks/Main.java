package chapter03.syn_utilities.demo05.phaser_tasks;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        // 3��������
        Phaser phaser = new Phaser(3);

        // ����3��FileSearch����,ÿ��������ͬ��Ŀ¼
        FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Settings", "log", phaser);

        Thread systemThread = new Thread(system, "System");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();

        try {
            // �ȴ�3���߳̽���
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Terminated: %s\n", phaser.isTerminated());
    }
}
