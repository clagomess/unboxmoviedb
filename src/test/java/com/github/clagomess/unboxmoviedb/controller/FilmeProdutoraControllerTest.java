package com.github.clagomess.unboxmoviedb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.clagomess.unboxmoviedb.entity.Filme;
import com.github.clagomess.unboxmoviedb.entity.FilmeProdutora;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang.RandomStringUtils;
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
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/production-companies/2")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());

        val response = result.getResponse().getContentAsString();
        log.info("{}", response);
        MatcherAssert.assertThat(response, CoreMatchers.containsString("movie_id"));
    }

    @Test
    @WithMockUser(value = "usuario-unit")
    public void insert() throws Exception {
        val entity = new FilmeProdutora();
        entity.setFilme(new Filme(1L));
        entity.setNome(RandomStringUtils.randomAlphanumeric(10));
        entity.setSglPais(RandomStringUtils.randomAlphanumeric(2).toUpperCase());

        String json = new ObjectMapper().writeValueAsString(entity);

        MvcResult result = mvc.perform(MockMvcRequestBuilders.put("/production-companies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andReturn();

        val response = result.getResponse().getContentAsString();
        log.info("{}", response);
        Assertions.assertEquals(200, result.getResponse().getStatus());
        MatcherAssert.assertThat(response, CoreMatchers.containsString("movie_id"));
        MatcherAssert.assertThat(response, CoreMatchers.containsString(entity.getNome()));
    }

    @Test
    @WithMockUser(value = "usuario-unit")
    public void update() throws Exception {
        val entity = new FilmeProdutora();
        entity.setIdFilmeProdutora(1L);
        entity.setFilme(new Filme(1L));
        entity.setNome(RandomStringUtils.randomAlphanumeric(10));
        entity.setSglPais(RandomStringUtils.randomAlphanumeric(2).toUpperCase());

        String json = new ObjectMapper().writeValueAsString(entity);

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/production-companies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andReturn();

        val response = result.getResponse().getContentAsString();
        log.info("{}", response);
        Assertions.assertEquals(200, result.getResponse().getStatus());
        MatcherAssert.assertThat(response, CoreMatchers.containsString("movie_id"));
        MatcherAssert.assertThat(response, CoreMatchers.containsString(entity.getNome()));
    }

    @Test
    @WithMockUser(value = "usuario-unit")
    public void list() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/production-companies/list")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());

        val response = result.getResponse().getContentAsString();
        log.info("{}", response);
        MatcherAssert.assertThat(response, CoreMatchers.containsString("movie_id"));
    }

    @Test
    @WithMockUser(value = "usuario-unit")
    public void delete() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/production-companies/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(204, result.getResponse().getStatus());
    }
}
