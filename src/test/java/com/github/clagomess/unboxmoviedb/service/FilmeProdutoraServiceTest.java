package com.github.clagomess.unboxmoviedb.service;

import com.github.clagomess.unboxmoviedb.entity.Filme;
import com.github.clagomess.unboxmoviedb.entity.FilmeProdutora;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@Transactional
public class FilmeProdutoraServiceTest {
    @Autowired
    private FilmeProdutoraService filmeProdutoraService;

    private Long seqFilmeProdutora;
    private String nomProdutora;

    @BeforeEach
    public void inserir() throws Exception {
        val entity = new FilmeProdutora();
        entity.setFilme(new Filme(1L));
        entity.setNomProdutora(RandomStringUtils.randomAlphanumeric(10));
        entity.setSglPais(RandomStringUtils.randomAlphanumeric(2).toUpperCase());

        filmeProdutoraService.save(entity);

        Assertions.assertNotNull(entity.getSeqFilmeProdutora());
        this.seqFilmeProdutora = entity.getSeqFilmeProdutora();
        this.nomProdutora = entity.getNomProdutora();
    }

    @Test
    public void findById() throws Exception {
        val entity = filmeProdutoraService.findById(this.seqFilmeProdutora);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(nomProdutora, entity.getNomProdutora());
    }

    @Test
    public void alterar() throws Exception {
        val entity = filmeProdutoraService.findById(this.seqFilmeProdutora);
        entity.setNomProdutora("Globo");

        filmeProdutoraService.save(entity);
    }

    @Test
    public void excluir() throws Exception {
        filmeProdutoraService.delete(this.seqFilmeProdutora);

        Assertions.assertThrows(Exception.class, () -> {
            filmeProdutoraService.findById(this.seqFilmeProdutora);
        });
    }

    @Test
    public void findAll() throws Exception {
        val list = filmeProdutoraService.findAll();

        log.info("{}", list);
        Assertions.assertNotNull(list);
        Assertions.assertEquals(3, list.size());
    }
}
