package com.github.clagomess.unboxmoviedb.repository;

import com.github.clagomess.unboxmoviedb.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    @Query("select new Filme(e.numVoto, e.numVotoMedia) from Filme e where e.seqFilme = ?1")
    Filme findFilmeParaCalculoVoto(Long seqFilme);

    @Modifying
    @Query("update Filme e set e.numVoto = ?1, e.numVotoMedia = ?2 where e.seqFilme = ?3")
    int setFilmeVoto(Long numVoto, Double numVotoMedia, Long seqFilme);
}
