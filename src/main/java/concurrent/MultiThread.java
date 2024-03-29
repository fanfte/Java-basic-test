package concurrent;

/**
 * Created by tianen on 2019/6/27
 *
 * @author fanfte
 * @date 2019/6/27
 **/
public class MultiThread {

    private static int num = 0;

    /** static */
    public static synchronized void printNum(String tag) {
        try {

            if (tag.equals("a")) {
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }

            System.out.println("tag " + tag + ", num = " + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 注意观察run方法输出顺序
    public static void main(String[] args) {

        // 俩个不同的对象
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();

    }

}
