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
    private Long idFilme;

    @JsonProperty("title")
    @Column(name = "nom_filme", nullable = false)
    private String titulo;

    @JsonProperty("original_title")
    @Column(name = "nom_filme_original", nullable = false)
    private String nomeOriginal;

    @JsonProperty("vote_count")
    @Column(name = "num_voto", nullable = false)
    private Long qtdVoto;

    @JsonProperty("vote_average")
    @Column(name = "num_voto_media", nullable = false)
    private Double mediaVoto;

    @JsonProperty("status")
    @Column(name = "sit_filme", nullable = false)
    private String status;

    @JsonProperty("production_companies")
    @OneToMany(mappedBy = "filme")
    private List<FilmeProdutora> produtoras;

    public Filme(Long qtdVoto, Double mediaVoto){
        this.qtdVoto = qtdVoto;
        this.mediaVoto = mediaVoto;
    }

    public Filme(Long seqFilme){
        this.idFilme = seqFilme;
    }
}
