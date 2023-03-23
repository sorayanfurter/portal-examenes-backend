package com.sistema.examenes.servicios;

import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;
import com.sistema.examenes.excepciones.UsuarioFoundException;
import com.sistema.examenes.excepciones.UsuarioNotFoundException;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws RuntimeException;

    public Usuario obtenerUsuario(String username) throws UsuarioNotFoundException;
    public void eliminarUsuario(Long usuarioId);
}
