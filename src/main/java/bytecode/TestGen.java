package bytecode;

import bytecode.utils.FileUtils;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by tianen on 2019/7/15
 *
 * @author fanfte
 * @date 2019/7/15
 **/
public class TestGen {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("D:\\WorkSpace\\javabasic\\src\\main\\java\\bytecode\\Test01.class");
        ClassReader cr = new ClassReader(in);
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
        ClassVisitor cv = new TraceClassVisitor(cw);
        cr.accept(cv, ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG);
        byte[] bytes =  cw.toByteArray();
        // 把改写以后的类文件字节数组写入到新的文件中
        FileUtils.writeByteArrayToFile(new File("D:\\WorkSpace\\javabasic\\src\\main\\java\\bytecode\\Test01new.class"), bytes, false);
    }
}
