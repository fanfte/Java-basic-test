package concurrent;

import java.io.Writer;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by tianen on 2019/6/5
 *
 * @author fanfte
 * @date 2019/6/5
 **/
public class TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        for (int i = 0; i < 4; i++) {
            new WriterThread(cyclicBarrier).start();
        }
    }

    private static class WriterThread extends Thread{
        private CyclicBarrier barrier;
        public WriterThread(CyclicBarrier cyclicBarrier) {
            this.barrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("所有线程写入数据完毕");
        }
    }
}
