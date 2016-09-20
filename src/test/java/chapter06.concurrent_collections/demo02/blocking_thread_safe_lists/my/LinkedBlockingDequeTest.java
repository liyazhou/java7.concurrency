package chapter06.concurrent_collections.demo02.blocking_thread_safe_lists.my;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeTest {

    @Test
    public void testAdd() {
        // ��������Ϊ3
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<String>(3);
        list.add("hello");
        list.add("world");
        list.add("haha");

        // ��ӵ�4��Ԫ���쳣
        list.add("fourth");    // java.lang.IllegalStateException: Deque full
    }
}
