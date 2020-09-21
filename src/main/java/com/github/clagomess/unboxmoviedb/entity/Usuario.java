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
    private Long idUsuario;

    @Column(name = "des_email", nullable = false)
    private String email;

    @Column(name = "des_senha", nullable = false)
    private String senha;

    public Usuario(Usuario usuario){
        this.email = usuario.email;
        this.senha = usuario.senha;
        this.idUsuario = usuario.idUsuario;
    }
}