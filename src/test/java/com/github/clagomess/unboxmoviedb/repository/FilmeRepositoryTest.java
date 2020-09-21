package com.github.clagomess.unboxmoviedb.repository;

import com.github.clagomess.unboxmoviedb.entity.Filme;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@SpringBootTest
public class FilmeRepositoryTest {
    @MockBean
    private FilmeRepository filmeRepository;

    @Test
    public void findFilmeParaCalculoVoto(){
        // mock
        Mockito.when(filmeRepository.findFilmeParaCalculoVoto(1L)).thenReturn(new Filme(18276L, 8.4));

        // tests
        val filme = filmeRepository.findFilmeParaCalculoVoto(1L);

        Assertions.assertNotNull(filme);
        Assertions.assertNull(filme.getIdFilme());
        Assertions.assertEquals(8.4, filme.getMediaVoto());
        Assertions.assertTrue(filme.getQtdVoto() > 0);
    }

    @Test
    public void setFilmeVoto(){
        // mock
        val filmeMock = new Filme();
        filmeMock.setIdFilme(1L);
        filmeMock.setMediaVoto(10.0);
        filmeMock.setQtdVoto(3L);

        Mockito.when(filmeRepository.findById(1L)).thenReturn(Optional.of(filmeMock));
        Mockito.when(filmeRepository.setFilmeVoto(3L, 10.0, 1L)).thenReturn(1);

        // tests
        int affected = filmeRepository.setFilmeVoto(3L, 10.0, 1L);

        Assertions.assertEquals(1, affected);

        val filme = filmeRepository.findById(1L).orElse(new Filme());

        Assertions.assertEquals(3L, filme.getQtdVoto());
        Assertions.assertEquals(10.0, filme.getMediaVoto());
    }
}
