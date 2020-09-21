package com.github.clagomess.unboxmoviedb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    @NotNull(message = "Necessário informar o id fo filme")
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seq_filme")
    private Filme filme;

    @NotBlank(message = "Necessário informar o nome da produtora")
    @JsonProperty("name")
    @Column(name = "nom_produtora", nullable = false)
    private String nome;

    @NotBlank(message = "Necessário informar a sigla do pais")
    @Size(min = 2, max = 2, message = "A sigla deve ter 2 digitos")
    @Pattern(regexp = "^\\D{2}", message = "A sigla não pode conter caracteres numericos")
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
