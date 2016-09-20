package chapter01.threadmanager.chapter01.threadmanager.demo08_uncheckedexception;

public class Task implements Runnable {

    @Override
    public void run() {
        // �׳��쳣
        // ������쳣��ExceptionHandler����
        Integer.parseInt("TTT");

        // ���ﲻ�ᱻִ�е�
        System.out.println("=====run end=====");
    }
}
