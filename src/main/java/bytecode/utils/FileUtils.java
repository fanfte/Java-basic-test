package bytecode.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tianen on 2019/7/15
 *
 * @author fanfte
 * @date 2019/7/15
 **/
public class FileUtils {
    public static void writeByteArrayToFile(File f, byte[] bytes, boolean b) {
        try {
            if (!f.exists()) {
                f.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("D:\\WorkSpace\\javabasic\\src\\main\\java\\bytecode\\new\\Test.class");
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
