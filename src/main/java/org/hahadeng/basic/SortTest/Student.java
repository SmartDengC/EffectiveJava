package org.hahadeng.basic.SortTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 学生类
 *
 * @author 邓聪
 * @since 2025/3/4 17:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{
    private String name;
    private Integer age;


    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }

    public static void main(String[] args) {
        List<Student> lit = new ArrayList<>();

        Student s1 = new Student("zs1", 18);
        Student s2 = new Student("zs2", 25);
        Student s3 = new Student("zs3", 16);
        Student s4 = new Student("zs4", 30);

        lit.add(s1);
        lit.add(s2);
        lit.add(s3);
        lit.add(s4);

        int i = s1.compareTo(s3);
        if(i > 0){
            System.out.println(s1.getName() + "比较大");
        } else if (i < 0) {
            System.out.println(s3.getName() + "比较大");
        }else{
            System.out.println("一样大");
        }

        Collections.sort(lit, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        lit.forEach(System.out::println);
    }
}
