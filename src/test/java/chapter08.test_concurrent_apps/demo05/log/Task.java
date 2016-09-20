package chapter08.test_concurrent_apps.demo05.log;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Task implements Runnable {

    @Override
    public void run() {
        Logger logger = MyLogger.getLogger(this.getClass().getName());

		/*
         * д����Ϣ��������ʼ (FINER)
		 */
        logger.entering(Thread.currentThread().getName(), "run()");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		/*
         * д����Ϣ����������� (FINER)
		 */
        logger.exiting(Thread.currentThread().getName(), "run()", Thread.currentThread());
    }

}
