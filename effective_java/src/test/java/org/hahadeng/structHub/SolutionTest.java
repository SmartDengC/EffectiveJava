package org.hahadeng.structHub;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void list1() {
        Solution solution = new Solution();
        solution.list1();
    }

    @Test
    void list2() {
        Solution solution = new Solution();
        solution.list2();
    }

    @Test
    void list(){
        Calendar calTmp = Calendar.getInstance();
        calTmp.setTime(new Date());
        System.out.println(
                calTmp.get(Calendar.YEAR) + "-" + (calTmp.get(Calendar.MONTH) + 1)  + "-" + calTmp.get(Calendar.DAY_OF_MONTH)
        );
        String nowTime = "2024-10-31";

    }
}
