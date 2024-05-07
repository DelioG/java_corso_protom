package it.learnspring.libreria.service;

import it.learnspring.libreria.dto.*;
import it.learnspring.libreria.mapper.AutoreMapper;
import it.learnspring.libreria.mapper.LibroMapper;
import it.learnspring.libreria.repository.AutoreRepository;
import it.learnspring.libreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.learnspring.libreria.entity.*;
import java.util.List;
import java.util.Optional;

@Service // Serve a Spring per capire che classe è (component di Spring).
public class LibreriaService {

    @Autowired
    AutoreRepository autoreRepository;
    @Autowired
    LibroRepository libroRepository;
    @Autowired
    AutoreMapper autoreMapper;
    @Autowired
    LibroMapper libroMapper;

    /* ***************************************************************** */
    /*                              LIBRO                                */
    /* ***************************************************************** */

    public List<LibroDTO> getAllBooks()
    {
        List<LibroDTO> listaLibri = libroMapper.libriToDTOs(libroRepository.findAll());
        return listaLibri;
    }

    public List<LibroDTO> getAllBooksOrdered()
    {
        List<LibroDTO> listaLibri = libroMapper.libriToDTOs(libroRepository.findAllBooksOrdered());
        return listaLibri;
    }

    public LibroDTO getBookByTitle(String titolo)
    {
        LibroDTO libroTrovato = libroMapper.libroToDTO(libroRepository.findBookByTitle(titolo));
        return libroTrovato;
    }

    /* ***************************************************************** */
    /*                              AUTORE                               */
    /* ***************************************************************** */

    public List<AutoreDTO> getAllAuthors()
    {
        System.out.println("sono dentro getAllAuthors nel service");
        List<AutoreDTO> listaAutori= autoreMapper.autoriToDtos(autoreRepository.findAll()); // findAll() è un metodo che riceviamo estendendo JpaRepository nel nostro AutoreRepository che da solo fa una select * sulla tabella.
        return listaAutori;
    }   // Prendere questo come riferimento

    public AutoreDTO createNewAuthor(AutoreDTO nuovoAutore)
    {
        // save(), è utilizzato per inserire dati nel Database.

        // Trasformo il DTO in Entity
        Autore autoreDaInserire = autoreMapper.autoreToEntity(nuovoAutore);
        autoreDaInserire = autoreRepository.save(autoreDaInserire);

        // AutoreDTO nuovo_autore = autoreMapper.autoreToDto(autoreDaInserire);
        return autoreMapper.autoreToDto(autoreDaInserire);
    }

    public AutoreDTO getAuthorById(Long id)
    {
        autoreRepository.findById(id);
        return null;
    }

    public AutoreDTO getAuthorByName(String nome)
    {
        AutoreDTO autoreTrovato = autoreMapper.autoreToDto(autoreRepository.findAutoreByNome(nome));
        return autoreTrovato;
    }

    public Boolean createNewBook(LibroDTO nuovoLibro, Long idAutore)
    {

        // Va bene fare anche... ->
        // Autore autore1 = autoreRepository.findById(idAutore).get();
        // Autore autore2 = getAuthorById(idAutore);
        // Autore autore3 = autoreTrovato.get();

        Optional<Autore> autoreTrovato = autoreRepository.findById(idAutore);

        if(autoreTrovato.isPresent())
        {
            Autore autore = autoreTrovato.get(); // Con get estraggo l'oggetto da dentro l'opzionale.
            Libro libro = libroMapper.libroToEntity(nuovoLibro);
            libro.setAutore(autore);
            libroRepository.save(libro);
            return true;
        }
        else
        {
           return false;
        }

    }

}