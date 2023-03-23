package com.sistema.examenes.configuraciones;

import com.sistema.examenes.entidades.JwtRequest;
import com.sistema.examenes.entidades.JwtResponse;
import com.sistema.examenes.excepciones.UsuarioNotFoundException;
import com.sistema.examenes.servicios.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthenticationService {
@Autowired
    private  JwtUtils jwtUtils;

@Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    public  JwtResponse autenticar (@RequestBody JwtRequest jwtRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
        jwtRequest.getUsername(),
        jwtRequest.getPassword()));
        if(userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername()) == null){
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }

        UserDetails userDetails =  this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String jwtToken = this.jwtUtils.generateToken(userDetails);

        return new JwtResponse(jwtToken);
    }

}
