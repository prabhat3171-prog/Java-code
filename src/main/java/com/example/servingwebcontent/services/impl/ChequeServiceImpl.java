package com.example.servingwebcontent.services.impl;

import com.example.servingwebcontent.services.ChequeService;
import com.example.servingwebcontent.utils.CommonUtil;
import org.springframework.stereotype.Service;

@Service
public class ChequeServiceImpl implements ChequeService {

    @Override
    public String convertAmountToWords(String amount) {
        if(amount != null && !amount.isBlank()) {
            String[] amnt = amount.split("\\.");
            String dollars = CommonUtil.numberToWord(Integer.parseInt(amnt[0])).toUpperCase();
            amount = dollars + " DOLLARS";
            if(amnt.length > 1) {
                String cents = CommonUtil.numberToWord(Integer.parseInt(amnt[1])).toUpperCase();
                amount += " AND " + cents + " CENTS";
            }
        }
        return amount;
    }
}
