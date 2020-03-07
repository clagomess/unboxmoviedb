package com.github.clagomess.unboxmoviedb.repository;

import com.github.clagomess.unboxmoviedb.entity.FilmeProdutora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeProdutoraRepository extends JpaRepository<FilmeProdutora, Long> {
}
