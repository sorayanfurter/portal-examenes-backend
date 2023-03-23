package com.sistema.examenes.servicios.impl;

import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.excepciones.UsuarioNotFoundException;
import com.sistema.examenes.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = this.usuarioRepository.findByUsername(username);
        if (usuario==null){
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }
}
