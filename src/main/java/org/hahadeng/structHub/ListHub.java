package org.hahadeng.structHub;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * ListHub
 *
 * @author 邓聪
 */
public class ListHub {

    public static void createList(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        Stream<Integer> stream = list.stream();
        // parallel adj 平行的；相似的；同时发生的 n共同点 v与...相似
        Stream<Integer> integerStream = list.parallelStream();
    }
}
