package concurrent;

/**
 * Created by tianen on 2019/6/27
 *
 * @author fanfte
 * @date 2019/6/27
 **/
public class TestLock{

    private static int num = 0;

    public static synchronized void printNum(String str) {

        try {
            if (str.equals("a")) {
                num = 1000;
                System.err.println("thread -> A over");
                Thread.sleep(1000);
            } else if (str.equals("b")) {
                num = 200;
                System.err.println("thread -> B over");
            }
            System.err.println("str：" + str + "\tnum：" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print(String str) {
        try {
            if (str.equals("a")) {
                num = 1000;
                System.err.println("thread -> A over");
                Thread.sleep(1000);
            } else if (str.equals("b")) {
                num = 200;
                System.err.println("thread -> B over");
            }
            System.err.println("str：" + str + "\tnum：" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestLock l1 = new TestLock();
        TestLock l2 = new TestLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                l1.printNum("a");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                l2.printNum("b");
            }
        });
        t1.start();
        t2.start();
    }
}
