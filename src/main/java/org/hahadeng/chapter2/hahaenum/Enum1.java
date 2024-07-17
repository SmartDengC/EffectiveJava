package org.hahadeng.chapter2.hahaenum;

/**
 * @author: HaHaDeng
 */

enum Color{
    RED, YELLOW, GREEN, BLACK
}
public class Enum1 {

    /**
     * 内部类中使用枚举
     */
    enum Role{
        // student
        student,
        // teacher
        teacher,
        // worker
        worker
    }

    public static void main(String[] args) {
        // RED
        System.out.println(Color.RED);
        // student
        System.out.println(Role.student);

        Color[] color = Color.values();
        for(Color c: color){
            // RED index： 0
            System.out.println(c + " index： " + c.ordinal());
        }
    }
}
