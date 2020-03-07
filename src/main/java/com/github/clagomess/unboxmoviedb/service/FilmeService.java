package com.github.clagomess.unboxmoviedb.service;

import com.github.clagomess.unboxmoviedb.entity.Filme;
import com.github.clagomess.unboxmoviedb.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class FilmeService {
    private FilmeRepository filmeRepository;

    public Filme findById(Long seqFilme) throws Exception {
        val filme = filmeRepository.findById(seqFilme).orElse(null);

        if(filme == null){
            throw new Exception("Registro não encotrado");
        }

        return filme;
    }
}
