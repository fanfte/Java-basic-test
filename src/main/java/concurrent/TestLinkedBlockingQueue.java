package concurrent;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tianen on 2019/7/16
 *
 * @author fanfte
 * @date 2019/7/16
 **/
public class TestLinkedBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(1000);
        q.offer("aaa");
        String item = q.take();
        System.out.println(item);
    }
}
