package it.learnspring.libreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "autore")
@Entity // Serve a Spring per capire che classe è (component di Spring).
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column // (unique = true) Serve a dire che deve essere unico nel database, @NotNull
    private String cognome;

    @OneToMany(mappedBy = "autore")
    private List<Libro> libri;

}
