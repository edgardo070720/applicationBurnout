package com.example.application.bornout.service;

import com.example.application.bornout.model.Curso;
import com.example.application.bornout.model.Docente;

public interface ICursoService {
    void seveCurso(Curso curso);
    Iterable<Curso> findAllCurso();
    void  updateCurso(Curso curso);

    void deleteCurso(long id);
}
