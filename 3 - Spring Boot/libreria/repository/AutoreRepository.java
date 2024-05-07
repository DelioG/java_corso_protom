package it.learnspring.libreria.repository;

import it.learnspring.libreria.entity.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository     // Serve a Spring per capire che classe è (component di Spring).
public interface AutoreRepository extends JpaRepository<Autore, Long> { // Il nome della entity su cui fare le query (Autore) e il tipo della sua chiave primaria (Long).

    Autore findAutoreByNome(String nome);

    // Questo metodo esegue la stessa cosa di findAutoreByNome, ma è giusto per far vedere un esempio con le query.
    @Query(value = "SELECT a.* FROM autore a WHERE a.nome = :nomeAutore", nativeQuery = true) // Serve a dire che il metodo deve lanciare una query.
    Autore findAuthorByName(@Param("nomeAutore") String nome);

}