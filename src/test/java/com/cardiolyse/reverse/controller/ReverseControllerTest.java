package com.cardiolyse.reverse.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;


@WebMvcTest(ReverseController.class)
@AutoConfigureMockMvc //need this in Spring Boot test
public class ReverseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void reverse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reverse/test")
                        .contentType(APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", is("tset")));
    }

    @Test
    public void error() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reverse/")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}

