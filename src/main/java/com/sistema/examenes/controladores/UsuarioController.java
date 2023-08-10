package com.sistema.examenes.controladores;

import com.sistema.examenes.entidades.Rol;
import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;
import com.sistema.examenes.servicios.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("https://portal-examenes.web.app/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody @Valid Usuario usuario){
        Set<UsuarioRol> usuarioRoles= new HashSet<>();
        return usuarioService.guardarUsuario(usuario, usuarioRoles);

    }
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username")String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId")Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }
}
