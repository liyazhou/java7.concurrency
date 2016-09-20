package chapter01.threadmanager.chapter01.threadmanager.demo09_inheritablethreadlocalvar;

// ���������߳���ʵ��һ���ֲ��������������̵߳��κεط������ʣ��ܹ����ٲ����Ĵ���
public class ThreadLocalTest {
    private static ThreadLocal<String> tl_1 = new ThreadLocal<String>() {
        // ���ر��̵߳����֣�����1
        @Override
        protected String initialValue() {
            return "Thread name 1 : " + Thread.currentThread().getName();
        }
    };
    private static ThreadLocal<String> tl_2 = new ThreadLocal<String>() {
        // ���ر��̵߳����֣�����2
        @Override
        protected String initialValue() {
            return "Thread name 2 : " + Thread.currentThread().getName();
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new ThreadLocalTest().prt();
                }
            }).start();
        }
    }

    // ��ӡ���̵߳�����
    public void prt() {
        System.out.println(tl_1.get());
        System.out.println(tl_2.get());
    }
}
