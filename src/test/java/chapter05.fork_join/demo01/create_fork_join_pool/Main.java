package chapter05.fork_join.demo01.create_fork_join_pool;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // ��Ʒ�б�
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(40);

        // ����һ������
        Task task = new Task(products, 0, products.size(), 0.20);

        // ����һ��ForJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // ִ������
        pool.execute(task);

        // ���pool����Ϣ
        do {
            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
            System.out.printf("Main: Paralelism: %d\n", pool.getParallelism());

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        // �ر�
        pool.shutdown();

        // ��������Ƿ��������
        if (task.isCompletedNormally()) {
            System.out.printf("Main: The process has completed normally.\n");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
            }
        }

        System.out.println("Main: End of the program.\n");
    }
}
