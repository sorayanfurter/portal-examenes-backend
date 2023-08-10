package com.sistema.examenes.controladores;

import com.sistema.examenes.configuraciones.AuthenticationService;
import com.sistema.examenes.configuraciones.JwtUtils;
import com.sistema.examenes.entidades.JwtRequest;
import com.sistema.examenes.entidades.JwtResponse;
import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.servicios.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("https://portal-examenes.web.app/")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")

        public ResponseEntity<JwtResponse> autenticar(@RequestBody JwtRequest jwtRequest){
            return ResponseEntity.ok(authenticationService.autenticar(jwtRequest));
        }


    private void autenticar(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}

