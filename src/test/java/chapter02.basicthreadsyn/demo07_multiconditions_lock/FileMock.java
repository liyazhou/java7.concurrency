package chapter02.basicthreadsyn.demo07_multiconditions_lock;

/**
 * ģ��һ��text�ļ�
 */
public class FileMock {

    // ģ���ļ�������
    private String[] content;

    // ��Ҫ������ı���
    private int index;

    /**
     * ʹ��������ַ�����ʼ���ļ�����
     * size : ����ĳ���
     * length : ������ÿ���ַ����ĳ���
     */
    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int) Math.random() * 255;
                buffer.append((char) indice);
            }

            content[i] = buffer.toString();
        }

        index = 0;
    }

    /**
     * �Ƿ���Ҫ������ı���
     */
    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.println("Mock: " + (content.length - index));
            return content[index++];
        }

        return null;
    }
}
