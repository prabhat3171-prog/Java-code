package com.example.servingwebcontent.restcontrollers;


import org.json.JSONException;
import org.json.JSONObject;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ChequeRestControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void convert() throws Exception {

        MvcResult result = this.mockMvc.perform(post("/convert")
                .param("name", "Prabhat")
                .param("amount", "123.45")
        ).andExpect(status().isOk()).andReturn();
        String resultDOW = result.getResponse().getContentAsString();
        try {
            JSONObject jsonObject = new JSONObject(resultDOW);
            assertEquals(jsonObject.getString("amount"), "ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS");
        }catch (JSONException err){
            System.out.println(err);
        }

    }
}
