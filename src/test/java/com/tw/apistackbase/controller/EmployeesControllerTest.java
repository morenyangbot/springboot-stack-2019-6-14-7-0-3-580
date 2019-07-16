package com.tw.apistackbase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_new_employee_when_post_a_new_employee() throws Exception {
        this.mockMvc
                .perform(post("/employees").content("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"Jerry1\",\n" +
                        "    \"age\": 23,\n" +
                        "    \"gender\": \"Male\"\n" +
                        "}").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"Jerry1\",\n" +
                        "    \"age\": 23,\n" +
                        "    \"gender\": \"Male\"\n" +
                        "}"));
    }
}