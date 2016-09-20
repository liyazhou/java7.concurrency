package chapter03.syn_utilities.demo05.phaser_tasks;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable {

    /**
     * ��ʼĿ¼
     */
    private String initPath;

    /**
     * �ļ��ĺ�׺��
     */
    private String end;

    /**
     * �洢Ҫ���ҵķ��Ϻ�׺�����ļ���ȫ·��
     */
    private List<String> results;

    /**
     * ����FileSearch�����ִ��.���ǵ�ִ�н��ֳ�3�����裺
     * 1. ��ָ����Ŀ¼����Ŀ¼�в���ָ����չ���ĵ��ļ�
     * 2. ���˽��.ֻ��õ������޸ĵ��ļ�
     * 3. ��ӡ���
     */
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        results = new ArrayList<>();
    }

    @Override
    public void run() {
        // �ȴ����е�FileSearah����Ĵ���,��������
        // ����Ҫ��Main�д�����system�߳�������,��ôҪ�ȴ�apps��documents�̴߳�������
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Starting.\n", Thread.currentThread().getName());

        // ��һ���������ļ�
        File file = new File(initPath);
        if (file.isDirectory()) {
            directoryProcess(file);
        }

        // ����б�Ϊ��,��phaser����Ȼ�����
        if (!checkResults()) {
            return;
        }

        // �ڶ��������˽��
        filterResults();

        // ����б�Ϊ��,��phaser����Ȼ�����
        if (!checkResults()) {
            return;
        }

        // ������, ��ӡ��Ϣ
        showInfo();
        phaser.arriveAndDeregister();
        System.out.printf("%s: Work completed.\n", Thread.currentThread().getName());
    }

    /**
     * ��һ�׶Σ�����Ŀ¼
     */
    private void directoryProcess(File file) {
        File[] list = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    // Ŀ¼, �ݹ����
                    directoryProcess(list[i]);
                } else {
                    // �ļ�
                    fileProcess(list[i]);
                }
            }
        }
    }

    private void fileProcess(File file) {
        if (file.getName().endsWith(end)) {
            // ���ļ���ȫ·�����뵽�б���
            results.add(file.getAbsolutePath());
        }
    }


    /**
     * �ڶ��׶Σ������ļ�. ���˵�һ�׶ΰ������б�.
     */
    private void filterResults() {
        List<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();
        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            long fileDate = file.lastModified();    // �ļ�������޸�ʱ��

            // ������24Сʱ,���뵽�б���
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(results.get(i));
            }
        }

        results = newResults;
    }


    /**
     * �����׶Σ���ӡ��Ϣ
     */
    private void showInfo() {
        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }

        // �ȴ�������phaser��ע���FileSearch����Ľ���
        phaser.arriveAndAwaitAdvance();
    }


    /**
     * �����
     */
    private boolean checkResults() {
        if (results.isEmpty()) {
            System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());
            System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
            // û��Ҫ���ҵ��ļ�.����Phaser
            // ����Phaser����߳��Ѿ�������ʵ�ʵĽ׶�,�����뿪phased�Ĳ���
            phaser.arriveAndDeregister();
            return false;
        } else {
            System.out.printf("%s: Phase %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(),
                    results.size());

            // �˽׶ν���.�ȴ�����ִ����һ��phase
            // ����Phaser����߳��Ѿ�������ʵ�ʵĽ׶�,��������ֱ��������׶εĲ��������в�����߳����ʵ�ʵĽ׶�
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

}
