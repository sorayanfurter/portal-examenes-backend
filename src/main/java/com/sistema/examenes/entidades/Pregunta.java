package com.sistema.examenes.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "preguntas")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preguntaId;
    @NotNull(message= "Debe ingresar una pregunta")
    @Column(length = 5000)
    private String contenido;
    private String imagen;
    @NotNull(message= "Debe ingresar una respuesta para la opción 1")
    private String opcion1;
    @NotNull(message= "Debe ingresar una respuesta para la opción 2")
    private String opcion2;
    @NotNull(message= "Debe ingresar una respuesta para la opción 3")
    private String opcion3;
    @NotNull(message= "Debe ingresar una respuesta para la opción 4")
    private String opcion4;
    @Transient
    private String respuestaDada;
    @NotNull(message = "Debe seleccionar una respuesta correcta")
    private String respuesta;

    @ManyToOne (fetch = FetchType.EAGER)
    private Examen examen;

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getRespuestaDada() {
        return respuestaDada;
    }

    public void setRespuestaDada(String respuestaDada) {
        this.respuestaDada = respuestaDada;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Pregunta(){

    }
}
