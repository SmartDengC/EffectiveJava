package org.hahadeng.learnhub;

import java.io.*;

/**
 * @author: HaHaDeng
 */

public class ExceptionHub {

    /**
     * try-with-resources 关闭资源的最佳方式
     */
    static String firstLineOfFile(String path) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /**
     * 在多个资源上使用try-with-resources， 简洁明了
     */
    static void copy(String src, String dst) throws IOException{
        try(InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)){
            byte[] buf = new byte[16];
            int n;
            while ((n = in.read(buf)) >= 0){
                out.write(buf, 0, n);
            }
        }
    }

    /**
     * 带有catch字句的try-with-resources
     */
    static String firstLineOfFile(String path, String defaultVal){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
}
