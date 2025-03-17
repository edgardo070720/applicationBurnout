package com.example.application.bornout.service.implementation;

import com.example.application.bornout.model.Curso;
import com.example.application.bornout.model.Docente;
import com.example.application.bornout.repository.CursoRepository;
import com.example.application.bornout.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public void seveCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public Iterable<Curso> findAllCurso(long id) {
        return cursoRepository.findByDocenteId(id);
    }

    @Override
    public void updateCurso(Curso curso) {
        cursoRepository.findById(curso.getId()).orElseThrow();
        cursoRepository.save(curso);
    }


    @Override
    public void deleteCurso(long id) {
        cursoRepository.findById(id).orElseThrow();
        cursoRepository.deleteById(id);
    }
}
