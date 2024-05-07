package it.learnspring.libreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "libro")
@Entity // Serve a Spring per capire che classe è (component di Spring).
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Indica che il campo id è auto-generato.
    private Long id;

    @Column(name = "titolo_libro")
    private String titolo;

    @Column
    private String genere;

    @Column
    private Double prezzo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")                // Il nome della colonna deve combaciare con il nome effettivo dell'altra tabella.
    private Autore autore;

}