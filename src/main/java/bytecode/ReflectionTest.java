package bytecode;

import java.lang.reflect.Method;

/**
 * Created by tianen on 2019/7/15
 *
 * @author fanfte
 * @date 2019/7/15
 **/
public class ReflectionTest {

    private static int count = 0;
    public static void foo() {
        new Exception("test#" + (count++)).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("bytecode.ReflectionTest");
        Method method = clz.getMethod("foo");
        for (int i = 0; i < 20; i++) {
            method.invoke(null);
        }
    }
}
