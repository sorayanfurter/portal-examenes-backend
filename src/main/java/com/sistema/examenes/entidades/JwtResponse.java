package com.sistema.examenes.entidades;

public class JwtResponse {

    private String jwtToken;

    public JwtResponse(){

    }

    public JwtResponse(String token) {
        this.jwtToken = token;
    }

    public String getToken() {
        return jwtToken;
    }

    public void setToken(String token) {
        this.jwtToken = token;
    }
}
