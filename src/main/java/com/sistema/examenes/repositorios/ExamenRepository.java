package com.sistema.examenes.repositorios;

import com.sistema.examenes.entidades.Categoria;
import com.sistema.examenes.entidades.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen, Long> {

     List<Examen> findByCategoria(Categoria categoria);

     List<Examen> findByActivo(Boolean estado);

     List<Examen> findByCategoriaAndActivo(Categoria categoria, Boolean estado);
}
