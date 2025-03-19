package com.example.application.bornout.DTOs;

import com.example.application.bornout.model.Curso;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocenteDTO {
    private long id;
    private String email;
    private String password;
    private String nombre;
    private List<CursoDTO> cursos;
}
