package com.github.clagomess.unboxmoviedb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tbl_usuario")
@NoArgsConstructor
public class Usuario {
    @Id
    @Column(name = "seq_usuario", nullable = false)
    private String seqUsuario;

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