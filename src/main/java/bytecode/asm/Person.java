package bytecode.asm;

/**
 * Created by tianen on 2019/7/15
 *
 * @author fanfte
 * @date 2019/7/15
 **/
public class Person {
    public void doJob(String jobName) {
        System.out.println("who is this class: " + getClass());
        System.out.println("doing job: " + jobName);
    }
}
