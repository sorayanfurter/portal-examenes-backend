package com.sistema.examenes.entidades;

import jakarta.persistence.*;

@Entity

public class UsuarioRol {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long usuarioRolId;

@ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

@ManyToOne
    private Rol rol;

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public UsuarioRol(){

    }
}
