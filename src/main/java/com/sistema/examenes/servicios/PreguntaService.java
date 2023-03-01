package com.sistema.examenes.servicios;

import com.sistema.examenes.entidades.Examen;
import com.sistema.examenes.entidades.Pregunta;

import java.util.Set;

public interface PreguntaService {

Pregunta agregarPregunta(Pregunta pregunta);
Pregunta actualizarPregunta(Pregunta pregunta);

Set<Pregunta> obtenerPreguntas();

Pregunta obtenerPregunta(Long preguntaId);

Set<Pregunta> obetenerPreguntasDelExamen(Examen examen);

void eliminarPregunta(Long examenId);
}
