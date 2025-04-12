package com.example.application.bornout.controller;

import com.example.application.bornout.DTOs.CursoDTO;

import com.example.application.bornout.service.implementation.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @PostMapping("/seve")
    public ResponseEntity<?> seveCuso(@RequestBody CursoDTO curso){
        try {
            cursoService.seveCurso(curso);
            return new ResponseEntity<>("se guardo su curso con exito", HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAllById/{id}")
    public ResponseEntity<?> findAllByIdCurso(@PathVariable long id){
        try {
            Iterable<CursoDTO> cursos= cursoService.findAllCurso(id);
            return new ResponseEntity<>(cursos,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateCurso(@RequestBody CursoDTO curso){
        try {
            cursoService.updateCurso(curso);
            return new ResponseEntity<>("se acrualizo con exito el curso",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable long id){
        try {
            cursoService.deleteCurso(id);
            return new ResponseEntity<>("se elimino con exito el curso",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
