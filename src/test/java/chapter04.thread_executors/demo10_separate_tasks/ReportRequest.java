package chapter04.thread_executors.demo10_separate_tasks;

import java.util.concurrent.CompletionService;

// �ύ����, ͨ��CompletionServiceִ��
public class ReportRequest implements Runnable {
    private String name;

    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        // ReportGenerator
        ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
        // ʹ��CompletionService�ύ����
        service.submit(reportGenerator);
    }
}
