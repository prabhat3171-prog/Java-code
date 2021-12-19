package com.example.servingwebcontent.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonUtilsTest {

    @Test
    public void numberToWord() {
        String amount = CommonUtil.numberToWord(123);
        assertEquals(amount, "ONE HUNDRED AND TWENTY-THREE");
    }
}
