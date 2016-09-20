package chapter03.syn_utilities.demo03.countdownlatch_wait_multi_events;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
    private Videoconference conference;

    /**
     * �����ߵ�����.ֻ����������־��¼��
     */
    private String name;

    public Participant(Videoconference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        Long duration = (long) (Math.random() * 10);

        try {
            // ����
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        conference.arrive(name);
    }

}
