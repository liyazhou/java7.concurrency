package chapter05.fork_join.demo03.run_task_asynchronously;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String path;

    // Ҫ���ҵ��ļ�����չ��
    private String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> list = new ArrayList<>(); // ������, �ļ���ȫ·��
        List<FolderProcessor> tasks = new ArrayList<>(); // ���潫Ҫ������Ŀ¼��������

        File file = new File(path);
        File[] content = file.listFiles();
        if (content != null) {
            for (int i = 0; i < content.length; i++) {
                if (content[i].isDirectory()) {
                    // ���������,ִ��һ���µ�����
                    FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(), extension);
                    task.fork();    // �첽ִ��
                    tasks.add(task);
                } else {
                    // ������ļ�,�Ƚ��ļ�����չ����Ҫ���ҵ���չ���Ƿ�һ��
                    if (checkFile(content[i].getName())) {
                        list.add(content[i].getAbsolutePath());
                    }
                }
            }

            // �����񳬹�50�������Ϣ
            if (tasks.size() > 50) {
                System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
            }

            // �ȴ��������,������
            addResultsFromTasks(list, tasks);
        }

        return list;
    }

    /**
     * ����join()�����ȴ�ִ�н���,join()��������������Ľ��.
     */
    private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
        for (FolderProcessor item : tasks) {
            list.addAll(item.join());
        }
    }

    private boolean checkFile(String name) {
        if (name.endsWith(extension)) {
            return true;
        }
        return false;
    }

}
