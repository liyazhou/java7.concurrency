package chapter01.threadmanager.chapter01.threadmanager.demo04_controlinterruption;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//		FileSearch searcher = new FileSearch("C:\\", "wordpad.exe");
        FileSearch searcher = new FileSearch("E:\\", "index.jsp");
        Thread thread = new Thread(searcher);
        thread.start();

        // �ȴ�1��
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // �ж��߳�
        thread.interrupt();
    }

//	Thread-0 : E:\C\index.jsp
//	Thread-0: The search has been interrupted
}

