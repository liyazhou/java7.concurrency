package chapter06.concurrent_collections.my.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterTest demo = new AtomicIntegerFieldUpdaterTest();
        demo.doit();
    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }

    void doit() {
        DemoData data = new DemoData();
        System.out.println("1 ==> " + getUpdater("value1").getAndSet(data, 10));    // 1 ==> 1
        System.out.println(data.value1);    // 10

        System.out.println("3 ==> " + getUpdater("value2").incrementAndGet(data));    // 3 ==> 3

        // Class my.atomic.AtomicIntegerFieldUpdaterTest can not access a protected member of class my.atomic.AtomicIntegerFieldUpdaterTest$DemoData using an instance of my.atomic.AtomicIntegerFieldUpdaterTest$DemoData
        //System.out.println("2 ==> " + getUpdater("value3").decrementAndGet(data));

        // Class my.atomic.AtomicIntegerFieldUpdaterTest can not access a member of class my.atomic.AtomicIntegerFieldUpdaterTest$DemoData with modifiers "private volatile"
        System.out.println("true ==> " + getUpdater("value4").compareAndSet(data, 4, 5));
    }

    class DemoData {
        public volatile int value1 = 1;
        protected volatile int value3 = 3;
        volatile int value2 = 2;
        private volatile int value4 = 4;
    }

}
