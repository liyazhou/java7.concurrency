package me.liyazhou.java7.concurrency.ch1.demo;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyazhou on 2015/6/18.
 */
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
                System.out.printf("%s: the search thread has been interrupted", Thread.currentThread().getName());
            }
        }

    }

    private void directoryProcess(File file) throws InterruptedException {
        File[] list = file.listFiles();
        for (int i = 0; list != null && i < list.length; i++) {
            if (list[i].isDirectory()) {
                directoryProcess(list[i]);
            } else {
                fileProcess(list[i]);
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public static void main(String[] args) {
        String initPath = "D:\\企业QQ";
        String fileName = "History.db";
        Thread fileSearch = new Thread(new FileSearch(initPath, fileName));
        fileSearch.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fileSearch.interrupt();

    }
}
