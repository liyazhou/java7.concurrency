package chapter01.threadmanager.chapter01.threadmanager.demo12_threadfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

// ʵ��ThreadFactory�ӿ�
public class MyThreadFactory implements ThreadFactory {

    // �����Ҫ���ݵ�����
    private int counter;
    private String name;
    private List<String> stats;

    // ����
    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<String>();
    }

    // ����һ���߳�
    @Override
    public Thread newThread(Runnable r) {
        // �����̶߳���
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;

        // ͳ��
        stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
        return t;
    }

    // ThreadFactory��ͳ����Ϣ
    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator();

        while (it.hasNext()) {
            buffer.append(it.next());
        }

        return buffer.toString();
    }
}
