package com.example.application.bornout.service;

import com.example.application.bornout.DTOs.CursoDTO;
import com.example.application.bornout.model.Curso;
import com.example.application.bornout.model.Docente;

public interface ICursoService {
    void seveCurso(CursoDTO curso);
    Iterable<CursoDTO> findAllCurso(long id);
    void  updateCurso(CursoDTO curso);

    void deleteCurso(long id);
}
