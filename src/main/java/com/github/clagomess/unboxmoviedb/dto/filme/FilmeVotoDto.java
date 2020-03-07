package com.github.clagomess.unboxmoviedb.dto.filme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FilmeVotoDto {
    @JsonProperty("movie_id")
    private Long movieId;
    private Double value;

    public FilmeVotoDto(Long movieId, Double value){
        this.movieId = movieId;
        this.value = value;
    }
}
