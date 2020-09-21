package com.github.clagomess.unboxmoviedb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_filme_produtora")
@NoArgsConstructor
public class FilmeProdutora {
    @Id
    @Column(name = "seq_filme_produtora", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_filme_produtora")
    @SequenceGenerator(name = "seq_filme_produtora", sequenceName = "seq_filme_produtora", allocationSize = 1)
    @JsonProperty("id")
    private Long idFilmeProdutora;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seq_filme")
    private Filme filme;

    @JsonProperty("name")
    @Column(name = "nom_produtora", nullable = false)
    private String nome;

    @JsonProperty("origin_country")
    @Column(name = "sgl_pais", nullable = false)
    private String sglPais;

    @Transient
    @JsonProperty("movie_id")
    private Long getSeqFilme(){
        return filme != null ? filme.getIdFilme() : null;
    }

    @Transient
    @JsonProperty("movie_id")
    private void setSeqFilme(Long seqFilme){
        filme = new Filme(seqFilme);
    }
}
