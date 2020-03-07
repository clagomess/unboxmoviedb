package com.github.clagomess.unboxmoviedb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.clagomess.unboxmoviedb.dto.filme.FilmeVotoDto;
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
public class FilmeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(value = "usuario-unit")
    public void getDetails() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/movie/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());

        val response = result.getResponse().getContentAsString();

        MatcherAssert.assertThat(response, CoreMatchers.containsString("original_title"));
    }

    @Test
    @WithMockUser(value = "usuario-unit")
    public void voto() throws Exception {
        String json = new ObjectMapper().writeValueAsString(new FilmeVotoDto(1L, 10.0));

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/movie/rating")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andReturn();

        val response = result.getResponse().getContentAsString();
        log.info("{}", response);
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }
}
