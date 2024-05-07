package it.learnspring.libreria.mapper;

import it.learnspring.libreria.entity.Libro;
import it.learnspring.libreria.dto.LibroDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class LibroMapper {

    public LibroDTO libroToDTO(Libro libro)
    {
        LibroDTO libroDTO = new LibroDTO();

        libroDTO.setId(libro.getId());
        libroDTO.setGenere(libro.getGenere());
        libroDTO.setTitolo(libro.getTitolo());
        libroDTO.setPrezzo(libro.getPrezzo());

        // Non chiamo il setter dell'altro oggetto.
        return libroDTO;
    }

    public List<LibroDTO> libriToDTOs (List<Libro> libri)
    {
        List<LibroDTO> libriDTO = new ArrayList<>();

        for(Libro libro : libri)
        {
            libriDTO.add(libroToDTO(libro));
        }

        return libriDTO;
    }

    public Libro libroToEntity(LibroDTO libro)
    {
        Libro libroEntity = new Libro();

        libroEntity.setId(libro.getId());
        libroEntity.setGenere(libro.getGenere());
        libroEntity.setTitolo(libro.getTitolo());
        libroEntity.setPrezzo(libro.getPrezzo());

        // Non chiamo il setter dell'altro oggetto
        return libroEntity;
    }

    public List<Libro> libriToEntities(List<LibroDTO> libri)
    {
        List<Libro> listaLibri = new ArrayList<>();

        if(libri == null || libri.isEmpty())
        {
            return Collections.emptyList();
        }

        for(LibroDTO libro : libri)
        {
            listaLibri.add(libroToEntity(libro));
        }

        return listaLibri;
    }

}