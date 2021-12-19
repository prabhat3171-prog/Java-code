package com.example.servingwebcontent.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChequeServiceTest {
    @Autowired
    ChequeService chequeService;

    @Test
    public void convertAmountToWords() {
        String amount = chequeService.convertAmountToWords("123.45");
        assertEquals(amount, "ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS");
    }
}
