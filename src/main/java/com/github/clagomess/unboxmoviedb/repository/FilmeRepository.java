package com.github.clagomess.unboxmoviedb.repository;

import com.github.clagomess.unboxmoviedb.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    @Query("select new Filme(e.qtdVoto, e.mediaVoto) from Filme e where e.idFilme = ?1")
    Filme findFilmeParaCalculoVoto(Long seqFilme);

    @Modifying
    @Query("update Filme e set e.qtdVoto = ?1, e.mediaVoto = ?2 where e.idFilme = ?3")
    int setFilmeVoto(Long numVoto, Double numVotoMedia, Long seqFilme);
}
