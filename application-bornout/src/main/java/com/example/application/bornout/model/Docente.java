package com.example.application.bornout.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String nombre;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Curso> cursos;

}
