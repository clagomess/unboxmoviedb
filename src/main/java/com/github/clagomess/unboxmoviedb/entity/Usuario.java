package com.github.clagomess.unboxmoviedb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_usuario")
@NoArgsConstructor
public class Usuario {
    @Id
    @Column(name = "seq_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
    private Long seqUsuario;

    @Column(name = "des_email", nullable = false)
    private String desEmail;

    @Column(name = "des_senha", nullable = false)
    private String desSenha;

    public Usuario(Usuario usuario){
        this.desEmail = usuario.desEmail;
        this.desSenha = usuario.desSenha;
        this.seqUsuario = usuario.seqUsuario;
    }
}