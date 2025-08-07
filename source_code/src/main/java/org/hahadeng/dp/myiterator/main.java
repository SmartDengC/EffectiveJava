package org.hahadeng.dp.myiterator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author 邓聪
 * @since 2025/6/4 10:16
 */
public class main {

    public static void main(String[] args) throws IOException {
        List<People> peopleList = new ArrayList<>();
        // 函数式编程。
        readPeople((people) -> {
            System.out.println(people);
            peopleList.add(people);
        });

        File file = new File("src/main/resources/demo.user");
        PeopleFile peopleFile = new PeopleFile(file);
        for (People o : peopleFile) {
            System.out.println(o);
        }
    }


    public static void readPeople(Consumer<People> peopleConsumer) throws IOException {
        List<String> lines = Files.readAllLines(new File("src/main/resources/demo.user").toPath());
        for (String line : lines) {
            String substring = line.substring(1, line.length() - 1);
            String[] split = substring.split(",");
            People people = new People(split[0], Integer.parseInt(split[1]));

            // 对People的操作传进来呢？
            // Consumer接口，函数式编程接口
            peopleConsumer.accept(people);
        }

    }
}
