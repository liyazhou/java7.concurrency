package chapter03.syn_utilities.demo06.control_phaser_change;

import java.util.concurrent.Phaser;

/**
 * ʵ��Phaser�������.����onAdvance()����ȥ����phase�ĸı�.
 **/
public class MyPhaser extends Phaser {

    /**
     * �����������arriveAndAwaitAdvance()�����б�����.
     * ����phase���Ե�ֵ,���ò�ͬ�ĸ�������.
     */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                return true;
        }

//		return super.onAdvance(phase, registeredParties);
    }

    /**
     * ��������ڽ׶�0���׶�1�ı��ʱ�����
     */
    private boolean studentsArrived() {
        System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
        System.out.printf("Phaser: We have %d students.\n", getRegisteredParties());
        return false;
    }

    /**
     * ��������ڽ׶�1���׶�2�ı��ʱ�����
     */
    private boolean finishFirstExercise() {
        System.out.printf("Phaser: All the students has finished the first exercise.\n");
        System.out.printf("Phaser: It's turn for the second one.\n");
        return false;
    }

    /**
     * ��������ڽ׶�2���׶�3�ı��ʱ�����
     */
    private boolean finishSecondExercise() {
        System.out.printf("Phaser: All the students has finished the second exercise.\n");
        System.out.printf("Phaser: It's turn for the third one.\n");
        return false;
    }

    /**
     * ��������ڽ׶�3���׶�4�ı��ʱ�����
     */
    private boolean finishExam() {
        System.out.printf("Phaser: All the students has finished the exam.\n");
        System.out.printf("Phaser: Thank you for your time.\n");
        return true;
    }
}

