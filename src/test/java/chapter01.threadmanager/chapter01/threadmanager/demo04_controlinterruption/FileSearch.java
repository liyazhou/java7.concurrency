package chapter01.threadmanager.chapter01.threadmanager.demo04_controlinterruption;

import java.io.File;

public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
                cleanResources();
            }
        }
    }

    // ������Դ,���ʾ����,�յ�ʵ��
    private void cleanResources() {

    }

    // ����Ŀ¼
    private void directoryProcess(File file) throws InterruptedException {
        // �õ����е��ļ�
        File[] list = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    // �����Ŀ¼,�ݹ����
                    directoryProcess(list[i]);
                } else {
                    // �ļ�
                    fileProcess(list[i]);
                }
            }
        }

        // ����Ƿ��ж�
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    // �����ļ�
    private void fileProcess(File file) throws InterruptedException {
        // ����ļ�����
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }

        // ����Ƿ��ж�
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

}
