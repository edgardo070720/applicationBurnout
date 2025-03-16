package com.example.application.bornout.service;

import com.example.application.bornout.model.Docente;

public interface IDocenteService {
    void seveDocente(Docente docente);
    Iterable<Docente> findAllDocente();
    void updateDocente(Docente docente);
    void deleteDocente(long id);
}
