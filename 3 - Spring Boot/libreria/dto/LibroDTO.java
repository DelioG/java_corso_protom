package it.learnspring.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {

    private Long id;
    private String titolo;
    private String genere;
    private Double prezzo;

}