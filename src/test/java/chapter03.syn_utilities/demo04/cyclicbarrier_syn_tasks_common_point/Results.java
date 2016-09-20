package chapter03.syn_utilities.demo04.cyclicbarrier_syn_tasks_common_point;

public class Results {

    /**
     * �洢���ֵ�������������ÿһ��
     */
    private int data[];

    /**
     * @param size ��
     */
    public Results(int size) {
        data = new int[size];
    }

    /**
     * ÿһ��,Ҫ���ҵ����ֳ��ֵĴ���
     *
     * @param position ������
     * @param value    ���ҵ����ֵ�ͳ�ƴ���
     */
    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
