package com.github.clagomess.unboxmoviedb.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
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

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class FilmeProdutoraControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(value = "usuario-unit")
    public void findById() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/production-companies/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());

        val response = result.getResponse().getContentAsString();
        log.info("{}", response);
        MatcherAssert.assertThat(response, CoreMatchers.containsString("movie"));
    }
}
