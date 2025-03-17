package com.example.application.bornout.repository;

import com.example.application.bornout.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    @Query("SELECT c FROM Curso c WHERE c.docente.id = :docenteId")
    List<Curso> findByDocenteId(@Param("docenteId") Long docenteId);
}
