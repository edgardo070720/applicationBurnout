package com.example.application.bornout.service.implementation;

import com.example.application.bornout.DTOs.CursoDTO;
import com.example.application.bornout.DTOs.DocenteDTO;
import com.example.application.bornout.model.Curso;
import com.example.application.bornout.model.Docente;
import com.example.application.bornout.repository.CursoRepository;
import com.example.application.bornout.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService implements ICursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public void seveCurso(CursoDTO curso) {
        cursoRepository.save(cursoDtoMap(curso));
    }

    @Override
    public Iterable<CursoDTO> findAllCurso(long id) {
        List<Curso> cursos=cursoRepository.findByDocenteId(id);
        return cursos.stream().map(curso -> {

            CursoDTO cursoDTO=new CursoDTO();
            cursoDTO.setId(curso.getId());
            cursoDTO.setNombre(curso.getNombre());
            cursoDTO.setDocente(DocenteDTO.builder().id(curso.getDocente().getId()).nombre(curso.getDocente().getNombre()).build());
            return  cursoDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void updateCurso(CursoDTO curso) {
        cursoRepository.findById(curso.getId()).orElseThrow();
        cursoRepository.save(cursoDtoMap(curso));
    }


    @Override
    public void deleteCurso(long id) {
        cursoRepository.findById(id).orElseThrow();
        cursoRepository.deleteById(id);
    }
    private Curso cursoDtoMap(CursoDTO cursoDTO){
         return Curso.builder().id(cursoDTO.getId()).nombre(cursoDTO.getNombre()).docente(Docente.builder().id(cursoDTO.getDocente().getId()).nombre(cursoDTO.getDocente().getNombre()).build()).build();
    }
}
