package com.github.clagomess.unboxmoviedb.repository;

import com.github.clagomess.unboxmoviedb.entity.Filme;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class FilmeRepositoryTest {
    @Autowired
    private FilmeRepository filmeRepository;

    @Test
    public void findFilmeParaCalculoVoto(){
        val filme = filmeRepository.findFilmeParaCalculoVoto(1L);

        Assertions.assertNotNull(filme);
        Assertions.assertNull(filme.getIdFilme());
        Assertions.assertEquals(8.4, filme.getMediaVoto());
        Assertions.assertTrue(filme.getQtdVoto() > 0);
    }

    @Test
    public void setFilmeVoto(){
        int affected = filmeRepository.setFilmeVoto(3L, 10.0, 1L);

        Assertions.assertEquals(1, affected);

        val filme = filmeRepository.findById(1L).orElse(new Filme());

        Assertions.assertEquals(3L, filme.getQtdVoto());
        Assertions.assertEquals(10.0, filme.getMediaVoto());
    }
}
