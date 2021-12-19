package com.example.servingwebcontent.restcontrollers;

import com.example.servingwebcontent.services.ChequeService;
import com.example.servingwebcontent.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ChequeRestController {

    @Autowired
    private ChequeService chequeService;

    @GetMapping("/")
    public String index() {
        return "Greetings from Java Take-away Tech Test!";
    }

    @PostMapping("/convert")
    public ResponseEntity<Map<String, String>> convert(@RequestParam(name="name", required=false, defaultValue="") String name,
                                                       @RequestParam(name="amount", required=false, defaultValue="") String amount) {
        Map<String, String> response = new HashMap<>();
        response.put("name", name);
        response.put("amount", chequeService.convertAmountToWords(amount));

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }
}
