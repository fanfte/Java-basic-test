package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianen on 2019/6/13
 *
 * @author fanfte
 * @date 2019/6/13
 **/
public class TestReentrantLock {

    private static ReentrantLock lock = new ReentrantLock(false);


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Thread " + Thread.currentThread().getName() + "start.");
                        try {
                            lock.lock();
                            System.out.println("queue length " + lock.getQueueLength());
                            System.out.println("Thread " + Thread.currentThread().getName() + "get Lock.");
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            }).start();
        }
    }
}
