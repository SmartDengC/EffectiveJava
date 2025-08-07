package org.hahadeng.learnHub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import jnr.ffi.annotations.In;
import org.python.util.PythonInterpreter;

/**
 * java执行python代码
 *
 * @author 邓聪
 * @since 2025/2/11 17:25
 */
public class RunPython {
    public static void runOne(){
        Process proc;
        try {
            // 执行py文件
            // 这种方式还是需要有python环境
            String filePath = "/Users/dengc4r/c4r_code/learning/java/EffectiveJava/src/main/java/org/hahadeng/learnHub/b.py";
            proc = Runtime.getRuntime().exec("python3 " + filePath);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void runTwo(){
        int a = 18;
        int b = 23;
        try {
            String filePath = "/Users/dengc4r/c4r_code/learning/java/EffectiveJava/src/main/java/org/hahadeng/learnHub/a.py";
            String[] args = new String[] { "python", filePath, String.valueOf(a), String.valueOf(b) };
            // 执行py文件
            Process proc = Runtime.getRuntime().exec(args);

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void runThree(){
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("import numpy as np");
        interpreter.exec("a=[5,2,3,9,4,0]; ");
        interpreter.exec("print(sorted(a));");  //此处python语句是3.x版本的语法
        interpreter.exec("print sorted(a);");   //此处是python语句是2.x版本的语法
    }

    public static void main(String[] args) {
//        RunPython.runTwo();
        RunPython.runThree();
        Map<Character, Integer> cnt = new HashMap<>();

        for(Map.Entry<Character, Integer> entry: cnt.entrySet()){
            if(entry.getValue() == 1){
                 Integer.valueOf(entry.getKey());
            }
        }
        List<Integer> l1 = (List<Integer>) cnt.values();

        for(int i = 0;i< l1.size();i++){
        }


    }

}
