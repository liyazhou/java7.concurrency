package chapter03.syn_utilities.demo04.cyclicbarrier_syn_tasks_common_point;

/**
 * �ϼƴ洢��Resultes�����е�ֵ,����CyclicBarrier�Զ�����,�����е�Searchers��������
 */
public class Grouper implements Runnable {

    /**
     * ÿ�г��ֵ�����
     */
    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    /**
     * �ϼƴ洢��Resultes�����е�ֵ
     */
    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        int data[] = results.getData();
        for (int number : data) {
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }

}
