package com.sistema.examenes.repositorios;

import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.excepciones.UsuarioNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository <Usuario, Long> {

    public Usuario findByUsername(String username);
}
