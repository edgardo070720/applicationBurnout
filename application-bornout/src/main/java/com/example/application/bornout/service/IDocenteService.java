package com.example.application.bornout.service;

import com.example.application.bornout.DTOs.DocenteDTO;
import com.example.application.bornout.model.Docente;

public interface IDocenteService {
    void seveDocente(DocenteDTO docente);
    Iterable<DocenteDTO> findAllDocente();
    void updateDocente(DocenteDTO docente);
    void deleteDocente(long id);
}
