package chapter08.test_concurrent_apps.demo05.log;

import java.util.logging.*;

public class MyLogger {

    private static Handler handler;

    public static Logger getLogger(String name) {
        // ȡ��Logger
        Logger logger = Logger.getLogger(name);

        // ���ü���
        logger.setLevel(Level.ALL);

        try {
            if (handler == null) {
                handler = new FileHandler("chapter08.test_concurrent_apps/demo05/log/jdklog.log");

                // ��־��ʽ
                Formatter format = new MyFormatter();
                handler.setFormatter(format);
            }

            if (logger.getHandlers().length == 0) {
                // handler
                logger.addHandler(handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return logger;
    }
}

