package bytecode.asm;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tianen on 2019/7/15
 *
 * @author fanfte
 * @date 2019/7/15
 **/
public class Test {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\WorkSpace\\javabasic\\src\\main\\java\\bytecode\\asm");
        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println(">>>>>before intercept");
                Object o = methodProxy.invokeSuper(obj, args);
                System.out.println(">>>>>end intercept");
                return o;
            }
        };
        Person person = (Person) Enhancer.create(Person.class, interceptor);
        person.doJob("coding");
    }
}
