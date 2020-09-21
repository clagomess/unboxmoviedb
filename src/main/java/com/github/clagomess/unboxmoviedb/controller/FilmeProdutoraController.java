package com.github.clagomess.unboxmoviedb.controller;

import com.github.clagomess.unboxmoviedb.entity.FilmeProdutora;
import com.github.clagomess.unboxmoviedb.service.FilmeProdutoraService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/production-companies")
@AllArgsConstructor
public class FilmeProdutoraController {
    private final FilmeProdutoraService filmeProdutoraService;

    @ApiOperation(value = "Busca uma produtora pelo id")
    @GetMapping("{seqFilmeProdutora}")
    public FilmeProdutora findById(
            @PathVariable("seqFilmeProdutora") Long seqFilmeProdutora
    ) throws Exception {
        return filmeProdutoraService.findById(seqFilmeProdutora);
    }

    @ApiOperation(value = "Atualiza uma produtora")
    @PutMapping
    public FilmeProdutora update(@RequestBody @Valid FilmeProdutora entity) throws Exception {
        entity.setIdFilmeProdutora(null);
        return filmeProdutoraService.save(entity);
    }

    @ApiOperation(value = "Insere uma produtora")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid FilmeProdutora entity) throws Exception {
        val result = filmeProdutoraService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna lista completa de produtoras")
    @GetMapping("list")
    public List<FilmeProdutora> list() throws Exception {
        return filmeProdutoraService.findAll();
    }

    @ApiOperation(value = "Exclui uma produtora")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("{seqFilmeProdutora}")
    public ResponseEntity<?> delete(
            @PathVariable("seqFilmeProdutora") Long seqFilmeProdutora
    ) throws Exception {
        filmeProdutoraService.delete(seqFilmeProdutora);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
