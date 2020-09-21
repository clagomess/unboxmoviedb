package com.github.clagomess.unboxmoviedb.dto.filme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class FilmeVotoDto {
    @JsonProperty("movie_id")
    @NotNull(message = "É necessário preencher o id do filme")
    private Long movieId;

    @DecimalMin(value = "0.0", message = "Valor do voto deve estar entre 0 e 10")
    @DecimalMax(value = "10.0", message = "Valor do voto deve estar entre 0 e 10")
    private Double value;

    public FilmeVotoDto(Long movieId, Double value){
        this.movieId = movieId;
        this.value = value;
    }
}
