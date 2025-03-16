package com.example.application.bornout.service.implementation;

import com.example.application.bornout.model.Docente;
import com.example.application.bornout.repository.DocenteRepository;
import com.example.application.bornout.service.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;

public class DocenteService implements IDocenteService {
    @Autowired
    private DocenteRepository docenteRepository;
    @Override
    public void seveDocente(Docente docente) {
        docenteRepository.save(docente);
    }

    @Override
    public Iterable<Docente> findAllDocente() {
        return docenteRepository.findAll();
    }

    @Override
    public void updateDocente(Docente docente) {
        docenteRepository.findById(docente.getId()).orElseThrow();
        docenteRepository.save(docente);
    }

    @Override
    public void deleteDocente(long id) {
        docenteRepository.findById(id).orElseThrow();
        docenteRepository.deleteById(id);
    }
}
