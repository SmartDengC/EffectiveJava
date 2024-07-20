package org.hahadeng.learnhub;

/**
 * 学习使用String字符串的方式
 */
public class StringHub {

    public static void main(String[] args) {
        String word = "Hello World";
        // 字符串长度
        int wordLength = word.length();
        // 字符串转字节数组
        char[] charArray = word.toCharArray();

        for(Character c: charArray){
            // 是否是大写字母
            boolean upperCase = Character.isUpperCase(c);
            boolean lowerCase = Character.isLowerCase(c);
            // 空格不是大写也不是小写
            System.out.println(upperCase + "--" + lowerCase);
        }

    }

}
