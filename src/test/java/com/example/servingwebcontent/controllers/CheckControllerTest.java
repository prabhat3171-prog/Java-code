package com.example.servingwebcontent.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void cheque() throws Exception {
        this.mockMvc.perform(get("/cheque")
        ).andExpect(status().isOk()) // 1
                .andExpect(view().name("cheque"));
    }

    @Test
    void chequeResponse() throws Exception {
        this.mockMvc.perform(get("/chequeResponse")
                        .param("name", "Prabhat")
                        .param("amount", "123.45")
                ).andExpect(status().isFound()) // 1
                .andExpect(view().name("cheque"))
                .andExpect(model().attribute("amount", "ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS"))
                .andExpect(model().attribute("name", "Prabhat"));
    }
}
