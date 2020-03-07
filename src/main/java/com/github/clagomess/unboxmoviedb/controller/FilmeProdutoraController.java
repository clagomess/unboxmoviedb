package com.github.clagomess.unboxmoviedb.controller;

import com.github.clagomess.unboxmoviedb.entity.FilmeProdutora;
import com.github.clagomess.unboxmoviedb.service.FilmeProdutoraService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production-companies")
@AllArgsConstructor
public class FilmeProdutoraController {
    private FilmeProdutoraService filmeProdutoraService;

    @GetMapping("{seqFilmeProdutora}")
    public FilmeProdutora findById(
            @PathVariable("seqFilmeProdutora") Long seqFilmeProdutora
    ) throws Exception {
        return filmeProdutoraService.findById(seqFilmeProdutora);
    }

    @PutMapping
    public FilmeProdutora insert(@RequestBody FilmeProdutora entity) throws Exception {
        entity.setSeqFilmeProdutora(null);
        return filmeProdutoraService.save(entity);
    }

    @PostMapping
    public FilmeProdutora update(@RequestBody FilmeProdutora entity) throws Exception {
        return filmeProdutoraService.save(entity);
    }

    @GetMapping("list")
    public List<FilmeProdutora> list() throws Exception {
        return filmeProdutoraService.findAll();
    }

    @DeleteMapping("{seqFilmeProdutora}")
    public ResponseEntity<?> delete(
            @PathVariable("seqFilmeProdutora") Long seqFilmeProdutora
    ) throws Exception {
        filmeProdutoraService.delete(seqFilmeProdutora);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
