package com.example.application.bornout.DTOs;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Builder
public class CursoDTO {
    private long id;
    private String nombre;
    private DocenteDTO docente;
}
