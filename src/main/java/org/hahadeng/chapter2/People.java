package org.hahadeng.chapter2;

/**
 * @author dCong
 * @package_name:org.test
 * @date: 2024/7/16
 * @desc:
 */

public class People {

    private int id;
    private String cd;
    private String name;
    private int calories;

    public static class Builder{
        // 必需参数
        private int id;
        private String cd;
        // 可选参数
        private String name = "";
        private int calories = 0;

        public Builder(int id, String cd){
            this.id = id;
            this.cd = cd;
        }

        // 创建一个与字段相同的方法，赋值对应的值，然后返回this
        public Builder calories(int val){
            calories = val;
            return this;
        }
        public Builder name(String val){
            name = val;
            return this;
        }
        // 使用build方法来创建外部类对象，将Builder的对象传入
        public People build(){
            return new People(this);
        }
    }

    private People(Builder builder){
        // 使用Builder实例来赋值外部类字段
        id = builder.id;
        cd = builder.cd;
        name = builder.name;
        calories = builder.calories;
    }

    public static void main(String[] args) {
        People d001 = new Builder(1, "d001").name("amy").calories(1110).build();
        People d003 = new Builder(2, "d002").name("amy").build();
    }
}
