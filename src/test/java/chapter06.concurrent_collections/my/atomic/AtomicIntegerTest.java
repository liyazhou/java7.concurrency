package chapter06.concurrent_collections.my.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    @Test
    public void testAll() throws InterruptedException {
        // �趨��ʼֵ
        final AtomicInteger value = new AtomicInteger(10);
        // compareAndSet()�������ǰֵ == Ԥ��ֵ,����ԭ�ӷ�ʽ����ֵ����Ϊ�����ĸ���ֵ. ����ɹ��ͷ���true,���򷵻�false,���Ҳ��޸�ԭֵ
        System.out.println(value.compareAndSet(1, 2));    // false
        System.out.println(value.get());                // 10
        System.out.println(value.compareAndSet(10, 3));    // true
        System.out.println(value.get());                // 3
        // ����Ϊ����ֵ.ֱ���޸�ԭʼֵ,Ҳ����i=newValue����
        value.set(0);

        // incrementAndGet()����ԭ�ӷ�ʽ����ǰֵ�� 1. �൱���̰߳�ȫ�汾��++i����
        System.out.println(value.incrementAndGet());    // 1
        // getAndAdd()����ԭ�ӷ�ʽ������ֵ�뵱ǰֵ���.�൱���̰߳�ȫ�汾��t=i;i+=delta;return t;����
        System.out.println(value.getAndAdd(2));            // 1
        System.out.println(value.get());                // 3
        System.out.println(value.getAndSet(5));            // 3
        System.out.println(value.get());                // 5


        final int threadSize = 10;
        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread() {
                @Override
                public void run() {
                    value.incrementAndGet();
                }
            };
        }

        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {
            t.join();
        }

        System.out.println(value.get());    // 15
    }

}
