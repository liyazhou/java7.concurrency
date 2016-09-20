package chapter06.concurrent_collections.demo03.blocking_thread_safe_orderby_priority;

/**
 * ʵ��Comparable�ӿ�
 */
public class Event implements Comparable<Event> {
    private int thread;

    // ���ȼ�
    private int priority;

    public Event(int thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    // ���бȽ�
    @Override
    public int compareTo(Event e) {
        if (this.priority > e.getPriority()) {
            return -1;
        } else if (this.priority < e.getPriority()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getThread() {
        return thread;
    }

    public int getPriority() {
        return priority;
    }

}
