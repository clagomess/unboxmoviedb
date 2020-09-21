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
        Assertions.assertFalse(filme.getProdutoras().isEmpty());
    }

    @Test
    public void manterVoto() throws Exception {
        val filmeAntes = filmeService.findFilmeParaCalculoVoto(1L);

        filmeService.manterVoto(1L, 10.0);

        val filmeDepois = filmeService.findFilmeParaCalculoVoto(1L);

        Assertions.assertEquals(filmeAntes.getQtdVoto() + 1, filmeDepois.getQtdVoto());
        Assertions.assertEquals(8.4, filmeDepois.getMediaVoto());
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
