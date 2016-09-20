package chapter03.syn_utilities.demo07.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable {
    /**
     * ͬ���������ߵĽ���
     */
    private final Exchanger<List<String>> exchanger;
    private List<String> buffer;

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;

        /**
         * 10��ѭ������
         */
        for (int i = 0; i < 10; i++) {
            System.out.printf("Producer: Cycle %d\n", cycle);

            /**
             * ÿ��ѭ����,��10���ַ������뵽buffer��
             */
            for (int j = 0; j < 10; j++) {
                String message = "Event " + ((i * 10) + j);
                System.out.printf("Producer: %s\n", message);
                buffer.add(message);
            }

            /**
             * �������߽������ݽ���
             */
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Producer: %d\n", buffer.size());
            cycle++;
        }
    }

}
