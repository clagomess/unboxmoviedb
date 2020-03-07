package com.github.clagomess.unboxmoviedb.controller;

import com.github.clagomess.unboxmoviedb.entity.Filme;
import com.github.clagomess.unboxmoviedb.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class FilmeController {
    private FilmeService filmeService;

    @GetMapping("{seqFilme}")
    public Filme getDetails(
            @PathVariable("seqFilme") Long seqFilme
    ) throws Exception {
        return filmeService.findById(seqFilme);
    }
}
