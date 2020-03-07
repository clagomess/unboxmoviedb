package com.github.clagomess.unboxmoviedb.service;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class FilmeServiceTest {
    @Autowired
    private FilmeService filmeService;

    @Test
    public void findById() throws Exception {
        val filme = filmeService.findById(1L);

        Assertions.assertNotNull(filme);
        Assertions.assertEquals(2, filme.getProdutoraList().size());
    }

    @Test
    public void manterVoto() throws Exception {
        filmeService.manterVoto(1L, 10.0);

        val filme = filmeService.findById(1L);

        Assertions.assertEquals(18277, filme.getNumVoto());
        Assertions.assertEquals(8.4, filme.getNumVotoMedia());
    }

    @Test
    public void manterVoto_vlrVoto_invalido() {
        Assertions.assertThrows(Exception.class, () -> filmeService.manterVoto(1L, 11.0));
    }

    @Test
    public void manterVoto_filme_inexistente() {
        Assertions.assertThrows(Exception.class, () -> filmeService.manterVoto(60L, 10.0));
    }
}
