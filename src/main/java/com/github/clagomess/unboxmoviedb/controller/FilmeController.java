package com.github.clagomess.unboxmoviedb.controller;

import com.github.clagomess.unboxmoviedb.dto.filme.FilmeVotoDto;
import com.github.clagomess.unboxmoviedb.entity.Filme;
import com.github.clagomess.unboxmoviedb.service.FilmeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class FilmeController {
    private final FilmeService filmeService;

    @ApiOperation(value = "Busca informções de um filme pelo ID")
    @GetMapping("{seqFilme}")
    public Filme getDetails(
            @PathVariable("seqFilme") Long seqFilme
    ) throws Exception {
        return filmeService.findById(seqFilme);
    }

    @ApiOperation(value = "Realiza o voto")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PostMapping("rating")
    public ResponseEntity<?> voto(@RequestBody FilmeVotoDto dto) throws Exception {
        filmeService.manterVoto(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
