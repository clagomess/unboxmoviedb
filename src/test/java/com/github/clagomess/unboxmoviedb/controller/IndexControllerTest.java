package com.github.clagomess.unboxmoviedb.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class IndexControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(value = "usuario-unit")
    public void index() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertEquals("Olá", result.getResponse().getContentAsString());
    }
}
