package chapter02.basicthreadsyn.demo01_synchronizedmethod.problem;

// ģ�����л��Զ��������˻���ȡǮ
public class Bank implements Runnable {
    // ����Ӱ����˻�
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }

}
