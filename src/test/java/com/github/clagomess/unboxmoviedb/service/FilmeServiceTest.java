package com.github.clagomess.unboxmoviedb.service;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FilmeServiceTest {
    @Autowired
    private FilmeService filmeService;

    @Test
    public void findById() throws Exception {
        val filme = filmeService.findById(1L);

        Assertions.assertNotNull(filme);
    }
}
