package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.services.ChequeService;
import com.example.servingwebcontent.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class ChequeController {

    @Autowired
    private ChequeService chequeService;

    @GetMapping("/cheque")
    public String cheque() {
        return "cheque";
    }

    @PostMapping("/chequeResponse")
    public String chequeResponse(@RequestParam(name="name", required=false, defaultValue="") String name,
                         @RequestParam(name="amount", required=false, defaultValue="") String amount,
                         Model model) {
        model.addAttribute("name", name);

        amount = chequeService.convertAmountToWords(amount);

        model.addAttribute("amount", amount);

        return "cheque";
    }
}
