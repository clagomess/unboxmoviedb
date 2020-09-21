package com.github.clagomess.unboxmoviedb.service;

import com.github.clagomess.unboxmoviedb.dto.filme.FilmeVotoDto;
import com.github.clagomess.unboxmoviedb.entity.Filme;
import com.github.clagomess.unboxmoviedb.exception.ServiceUnboxMovieDbException;
import com.github.clagomess.unboxmoviedb.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Transactional
@AllArgsConstructor
@Validated
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

    public void manterVoto(@Valid FilmeVotoDto dto) throws Exception {
        if(!filmeRepository.existsById(dto.getMovieId())){
            throw new ServiceUnboxMovieDbException("Filme não encontrado");
        }

        val filme = filmeRepository.findFilmeParaCalculoVoto(dto.getMovieId());
        long novoNumVoto = filme.getQtdVoto() + 1;
        Double novoNumVotoMedia = (filme.getMediaVoto() * filme.getQtdVoto() + dto.getValue()) / novoNumVoto;

        filmeRepository.setFilmeVoto(novoNumVoto, novoNumVotoMedia, dto.getMovieId());
    }

    public Filme save(Filme entity) throws Exception {
        filmeRepository.save(entity);
        return entity;
    }
}
