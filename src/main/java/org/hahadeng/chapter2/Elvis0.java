package org.hahadeng.chapter2;

/**
 * @author: HaHaDeng
 */

/**
 * Singleton
 * 通过暴露出一个static final 的类对象
 */
public class Elvis0 {
    public static final Elvis0 INSTANCE = new Elvis0("denh", "邓哈哈");

    private String cd;
    private String name;

    private Elvis0(String cd, String name){
        this.cd = cd;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Elvis0{" +
                "cd='" + cd + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Elvis0 elvis0 = Elvis0.INSTANCE;
        System.out.println(elvis0.toString());
    }
}
