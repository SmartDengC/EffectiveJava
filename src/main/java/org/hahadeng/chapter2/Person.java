package org.hahadeng.chapter2;

import com.sun.tools.classfile.ConstantPool;

import java.util.concurrent.ForkJoinPool;

/**
 * @author: HaHaDeng
 */


public class Person {

    private Integer id;
    private String cd;
    private String name;
    private Integer age;
    private Float salary;
    private String area;
    private String phone;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", cd='" + cd + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", area='" + area + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    // 创建一个建造类

    public static class Builder{
        private String cd;
        private String name;
        private Integer id = 0;
        private Integer age = 0;
        private Float salary = 0f;
        private String area = "";
        private String phone;

        // 静态内部类的构造，这里面只有必须的属性
        public Builder(String cd, String name){
            this.cd = cd;
            this.name = name;
        }

        // 然后就是对每个属性配置的方法
        public Builder id(Integer val){
            id = val;
            return this;
        }

        public Builder salary(Float val) {
            this.salary = val;
            return this;
        }

        public Builder area(String val) {
            this.area = val;
            return this;
        }

        public Builder phone(String val) {
            this.phone = val;
            return this;
        }

        // 最后需要有一个build的方法，这个方法返回一个外部类， 外部类需要有一个带有Builder的构造函数的方法
        // 用来创建对象
        public Person build(){
            return new Person(this);
        }
    }


    /**
     * 这个就是外部类的构造函数
     */
    private Person(Builder builder){
        id = builder.id;
        cd = builder.cd;
        name = builder.name;
        age = builder.age;
        salary = builder.salary;
        area = builder.area;
        phone = builder.phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void main(String[] args) {
        // 这个就是链式的使用
        Person build = new Builder("cd", "name").salary(200f).area("四川").build();
        build.setPhone("iphone");
        System.out.println(build.toString());

    }

}
