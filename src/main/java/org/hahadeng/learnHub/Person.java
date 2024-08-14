package org.hahadeng.learnHub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 *
 * @author 邓聪
 */
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int salary;
    private int age;
    private String sex;
    private String area;

    public Person(String name, int salary,String sex,String area) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.area = area;
    }
    public Person(String name, int salary, int age,String sex,String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }
}
