package com.github.clagomess.unboxmoviedb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_filme")
@NoArgsConstructor
public class Filme {
    @Id
    @Column(name = "seq_filme", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_filme")
    @SequenceGenerator(name = "seq_filme", sequenceName = "seq_filme", allocationSize = 1)
    @JsonProperty("id")
    private Long seqFilme;

    @JsonProperty("title")
    @Column(name = "nom_filme", nullable = false)
    private String nomFilme;

    @JsonProperty("original_title")
    @Column(name = "nom_filme_original", nullable = false)
    private String nomFilmeOriginal;

    @JsonProperty("vote_count")
    @Column(name = "num_voto", nullable = false)
    private Long numVoto;

    @JsonProperty("vote_average")
    @Column(name = "num_voto_media", nullable = false)
    private Double numVotoMedia;

    @JsonProperty("status")
    @Column(name = "sit_filme", nullable = false)
    private String sitFilme;

    @JsonProperty("production_companies")
    @OneToMany(mappedBy = "filme")
    private List<FilmeProdutora> produtoraList;

    public Filme(Long numVoto, Double numVotoMedia){
        this.numVoto = numVoto;
        this.numVotoMedia = numVotoMedia;
    }
}
