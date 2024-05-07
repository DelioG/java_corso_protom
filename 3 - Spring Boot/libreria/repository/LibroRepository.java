package it.learnspring.libreria.repository;

import it.learnspring.libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findLibroByTitolo(String titolo);

    // @Query Serve a dire che il metodo deve lanciare una query.
    @Query(value = "SELECT l.* FROM libro l ORDER BY l.prezzo DESC", nativeQuery = true)
    List<Libro> findAllBooksOrdered();

    @Query(value = "SELECT l.* FROM libro l WHERE l.titolo_libro = :nomeLibro", nativeQuery = true)
    Libro findBookByTitle(@Param("nomeLibro") String titolo);

}