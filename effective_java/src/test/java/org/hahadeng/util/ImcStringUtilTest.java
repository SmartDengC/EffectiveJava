package org.hahadeng.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class ImcStringUtilTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isEmpty() {
        Date date = new Date();
        System.out.println(ImcStringUtil.isEmpty(date));
    }

    @Test
    void isNotEmpty() {
    }

    @Test
    void main(){
        Random rnd = ThreadLocalRandom.current();
        System.out.println(rnd.nextInt());
    }
}
