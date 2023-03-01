package com.sistema.examenes.controladores;


import com.sistema.examenes.entidades.Examen;
import com.sistema.examenes.servicios.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }

    @PutMapping("/")
    public ResponseEntity<Examen> actualizarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }

    @GetMapping("/{examenId}")
    public Examen listarExamen(@PathVariable("examenId") Long examenId){
        return examenService.obtenerExamen(examenId);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarExamenes(){
        return ResponseEntity.ok(examenService.obtenerExamenes());
    }

    @DeleteMapping("/{examenId}")
    public void eliminarExamen(@PathVariable("examenId") Long examenId){
        examenService.eliminarExamen(examenId);
    }
}

