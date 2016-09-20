package chapter01.threadmanager.chapter01.threadmanager.demo09_inheritablethreadlocalvar;

/**
 * ThreadLocal�и�ȱ��, �����߳����޷����ʸ��̵߳ı���,
 * InheritableThreadLocal ������������, �Զ���Ѹ��̵߳ı������ݸ����߳�,
 * ���߳�ֻ����, �޸��˲���Ӱ�츸�̵߳Ķ���, ������Ȼ��Ҫע�Ⲣ��ʵ��~
 * ��Main2_2һ��������Ƚ�
 * <p/>
 * http://czh.iteye.com/blog/724206
 */
public class Main2 {

    // InheritableThreadLocal
    private final static InheritableThreadLocal<String> holder = new InheritableThreadLocal<String>();

    public static void main(String[] args) {
        holder.set("aaa");
        System.out.println("begin=" + holder.get());                    // aaa
        // ���߳�a
        Thread a = new Thread() {
            @Override
            public void run() {
                System.out.println("thread-begin=" + holder.get());        // aaa
                // �޸�ֵ
                holder.set("vvvvvvvvvvvvv");
                // ֻ��������������,������Ӱ�츸�߳�
                System.out.println("thread-end=" + holder.get());        // vvvvvvvvvvvvv
            }
        };
        a.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ��Ȼa�߳��޸���holder��ֵ, ���ǲ�����Ӱ�����߳�(���߳�)
        System.out.println("end=" + holder.get());                        // aaa
    }

    /**
     begin=aaa
     thread-begin=aaa
     thread-end=vvvvvvvvvvvvv
     end=aaa
     */
}
