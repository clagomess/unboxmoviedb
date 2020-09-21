package com.github.clagomess.unboxmoviedb.service;

import com.github.clagomess.unboxmoviedb.entity.FilmeProdutora;
import com.github.clagomess.unboxmoviedb.exception.ServiceUnboxMovieDbException;
import com.github.clagomess.unboxmoviedb.repository.FilmeProdutoraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FilmeProdutoraService {
    private final FilmeProdutoraRepository filmeProdutoraRepository;

    public FilmeProdutora findById(Long seqFilmeProdutora) throws Exception {
        Optional<FilmeProdutora> entity = filmeProdutoraRepository.findById(seqFilmeProdutora);

        if(!entity.isPresent()){
            throw new ServiceUnboxMovieDbException("Produtora não encontrada");
        }

        return entity.get();
    }

    public FilmeProdutora save(FilmeProdutora entity) throws Exception {
        filmeProdutoraRepository.save(entity);
        return entity;
    }

    public void delete(Long seqFilmeProdutora) throws Exception {
        filmeProdutoraRepository.deleteById(seqFilmeProdutora);
    }

    public List<FilmeProdutora> findAll() throws Exception {
        return filmeProdutoraRepository.findAll();
    }
}
