package bytecode;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;

/**
 * Created by tianen on 2019/7/15
 *
 * @author fanfte
 * @date 2019/7/15
 **/
public class Foo {
    public static int foo() {
        int x = 0;
        try {
            return x;
        } finally {
            ++x;
        }
    }

    public void print(List<String> list)  { }

    public static void main(String[] args) {
        int res = foo();
        System.out.println(res);
    }
}
