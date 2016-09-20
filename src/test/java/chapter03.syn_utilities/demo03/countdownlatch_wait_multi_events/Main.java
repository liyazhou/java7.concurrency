package chapter03.syn_utilities.demo03.countdownlatch_wait_multi_events;

public class Main {
    public static void main(String[] args) {
        // 10��������
        Videoconference conference = new Videoconference(10);

        // ��Ƶ-�����߳�����
        Thread threadConference = new Thread(conference);
        threadConference.start();

        // ����10��������,ÿ��ʹ��1���߳�����
        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
