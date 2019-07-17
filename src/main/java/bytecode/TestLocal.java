package bytecode;

/**
 * Created by tianen on 2019/7/15
 *
 * @author fanfte
 * @date 2019/7/15
 **/
public class TestLocal {
    public void foo() {
        int b = 0;
        System.out.println(b);
    }

    public static void main(String[] args) {
        TestLocal testLocal = new TestLocal();
        testLocal.foo();
    }
}
