package chapter01.threadmanager.chapter01.threadmanager.demo09_inheritablethreadlocalvar;

/**
 * InheritableThreadLocal��ʹ��
 * �����ʾ����, ���̣߳����߳�(Main)   ���̣߳������߳�
 * http://www.blogjava.net/stone2083/archive/2010/07/23/326894.html
 */
public class Main {
    // ����t1���������ﻹ��main()��,Child-1��ֵ��Ϊnull
    static final ThreadLocal<String> t1 = new ThreadLocal<String>();

    public static void main(String[] args) {
        // ʹ��ThreadLocal,�����߳�֮��,������value
//		final ThreadLocal<String> t1 = new ThreadLocal<String>();
        t1.set("ThreadLocal-VAL");
        System.out.println("Main-1:" + t1.get());
        // ���̲߳��������߳�(�����߳�)
        new Thread() {
            @Override
            public void run() {
                // �޷�ȡ��ֵ
                System.out.println("Child-1:" + t1.get());    // null
            }
        }.start();

        // �޷�ȡ��t1��ֵ
        Sub sub = new Sub(t1);
        sub.start();    // null


        // ʹ��InheritableThreadLocal,���߳�Value�������̹߳���
        final ThreadLocal<String> itl = new InheritableThreadLocal<String>();
        itl.set("InheritableThreadLocal-VAL");
        System.out.println("Main-2:" + itl.get());
        // ���̲߳��������߳�(�����߳�)
        new Thread() {
            @Override
            public void run() {
                System.out.println("Child-2:" + itl.get());    // InheritableThreadLocal-VAL
            }
        }.start();

        Sub sub2 = new Sub(itl);
        sub2.start();
    }


    /**
     Main-1:ThreadLocal-VAL
     Child-1:null
     Main-2:InheritableThreadLocal-VAL
     Sub Thread :null
     Child-2:InheritableThreadLocal-VAL
     Sub Thread :InheritableThreadLocal-VAL
     */
}

class Sub extends Thread {
    ThreadLocal<String> t1;

    public Sub(ThreadLocal<String> t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        System.out.println("Sub Thread :" + t1.get());
    }
}

