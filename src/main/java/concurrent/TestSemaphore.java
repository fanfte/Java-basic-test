package concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by tianen on 2019/6/5
 *
 * @author fanfte
 * @date 2019/6/5
 **/
public class TestSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 5; i++) {
            new Worker(i, semaphore).start();
        }
    }

    public static class Worker extends Thread {
        private int num;

        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
