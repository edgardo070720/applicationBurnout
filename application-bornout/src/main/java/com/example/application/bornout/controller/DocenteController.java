package com.example.application.bornout.controller;


import com.example.application.bornout.DTOs.DocenteDTO;

import com.example.application.bornout.service.implementation.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {
    @Autowired
    private DocenteService docenteService;

    @PostMapping("/seve")
    public ResponseEntity<String> seveDocente(@RequestBody DocenteDTO docente){
        try {
            docenteService.seveDocente(docente);
            return new ResponseEntity<>("Se guardo el docete con exito",HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAllDocente(){
        try {
            Iterable<DocenteDTO> docentes= docenteService.findAllDocente();
            return new ResponseEntity<>(docentes,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update")
    public  ResponseEntity<?> updateDocente(@RequestBody DocenteDTO docente){
        try {
            docenteService.updateDocente(docente);
            return new ResponseEntity<>("se actualizo con exito",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDocente(@PathVariable Long id){
        try {
            docenteService.deleteDocente(id);
            return  new ResponseEntity<>("se elimino con exito",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
