package com.github.clagomess.unboxmoviedb.dto.filmeProdutora;

import com.github.clagomess.unboxmoviedb.entity.FilmeProdutora;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FilmeProdutoraDto extends FilmeProdutora {
    private Long seqFilme;
}
