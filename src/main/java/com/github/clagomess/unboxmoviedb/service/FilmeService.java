package com.github.clagomess.unboxmoviedb.service;

import com.github.clagomess.unboxmoviedb.entity.Filme;
import com.github.clagomess.unboxmoviedb.exception.ServiceUnboxMovieDbException;
import com.github.clagomess.unboxmoviedb.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public Filme findById(Long seqFilme) throws Exception {
        val filme = filmeRepository.findById(seqFilme).orElse(null);

        if(filme == null){
            throw new ServiceUnboxMovieDbException("Registro não encotrado");
        }

        return filme;
    }

    public Filme findFilmeParaCalculoVoto(Long seqFilme) throws Exception {
        return filmeRepository.findFilmeParaCalculoVoto(seqFilme);
    }

    public void manterVoto(Long seqFilme, Double vlrVoto) throws Exception {
        // validar
        if(vlrVoto > 10.0){
            throw new ServiceUnboxMovieDbException("Valor do voto deve estar entre 0 e 10");
        }

        if(!filmeRepository.existsById(seqFilme)){
            throw new ServiceUnboxMovieDbException("Filme não encontrado");
        }

        val filme = filmeRepository.findFilmeParaCalculoVoto(seqFilme);
        long novoNumVoto = filme.getQtdVoto() + 1;
        Double novoNumVotoMedia = (filme.getMediaVoto() * filme.getQtdVoto() + vlrVoto) / novoNumVoto;

        filmeRepository.setFilmeVoto(novoNumVoto, novoNumVotoMedia, seqFilme);
    }

    public Filme save(Filme entity) throws Exception {
        filmeRepository.save(entity);
        return entity;
    }
}
