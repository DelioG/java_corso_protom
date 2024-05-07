package it.learnspring.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoreDTO {

    private Long id;
    private String nome;
    private String cognome;
    private List<LibroDTO> libri;

}