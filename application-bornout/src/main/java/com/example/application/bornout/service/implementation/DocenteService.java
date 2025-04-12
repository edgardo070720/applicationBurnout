package com.example.application.bornout.service.implementation;

import com.example.application.bornout.DTOs.CursoDTO;
import com.example.application.bornout.DTOs.DocenteDTO;

import com.example.application.bornout.model.Docente;
import com.example.application.bornout.repository.DocenteRepository;
import com.example.application.bornout.service.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteService implements IDocenteService {
    @Autowired
    private DocenteRepository docenteRepository;
    @Override
    public void seveDocente(DocenteDTO docente) {
        docenteRepository.save(docenteDtoMap(docente));
    }

    @Override
    public Iterable<DocenteDTO> findAllDocente() {

        List<Docente> docentes=docenteRepository.findAll();
        return docentes.stream().map(docente -> DocenteDTO.builder().id(docente.getId()).nombre(docente.getNombre()).email(docente.getEmail()).password(docente.getPassword()).cursos(docente.getCursos().stream().map(curso -> CursoDTO.builder().id(curso.getId()).nombre(curso.getNombre()).build()).collect(Collectors.toList())).build()).collect(Collectors.toList()) ;
    }

    @Override
    public void updateDocente(DocenteDTO docente) {
        docenteRepository.findById(docente.getId()).orElseThrow();
        docenteRepository.save(docenteDtoMap(docente));
    }

    @Override
    public void deleteDocente(long id) {
        docenteRepository.findById(id).orElseThrow();
        docenteRepository.deleteById(id);
    }
    private Docente docenteDtoMap(DocenteDTO docenteDTO){
        return Docente.builder().id(docenteDTO.getId()).nombre(docenteDTO.getNombre()).email(docenteDTO.getEmail()).password(docenteDTO.getPassword()).build();
    }
}
