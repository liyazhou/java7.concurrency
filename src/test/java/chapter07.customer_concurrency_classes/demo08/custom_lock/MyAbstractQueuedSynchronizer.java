package chapter07.customer_concurrency_classes.demo08.custom_lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * �̳���AbstractQueueSynchronizer��ȥʵ��һ����������,��ʹ��һ��AtomicInteger�������洢����״̬.
 * ��Ҳ�洢��ǰ��ȡ�����߳�.TryAcquire()������tryRelease()����������ʵ�ֵ����.
 */
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �洢lock��״̬������.0-free, 1-busy
     */
    private AtomicInteger state;

    public MyAbstractQueuedSynchronizer() {
        state = new AtomicInteger(0);
    }

    @Override
    public boolean tryAcquire(int arg) {
        return state.compareAndSet(0, 1);
    }

    @Override
    public boolean tryRelease(int arg) {
        return state.compareAndSet(1, 0);
    }
}

