package chapter08.test_concurrent_apps.demo05.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

    /**
     * ��Logger�����
     */
    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();

        sb.append("[" + record.getLevel() + "] - ");
        sb.append(new Date(record.getMillis()) + " : ");
        sb.append(record.getSourceClassName() + "." + record.getSourceMethodName() + " : ");
        sb.append(record.getMessage() + "\n");

        return sb.toString();
    }

}
