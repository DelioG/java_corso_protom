package it.learnspring.libreria.mapper;

import it.learnspring.libreria.dto.*;
import it.learnspring.libreria.entity.Autore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutoreMapper {

    @Autowired
    LibroMapper libroMapper;

    public AutoreDTO autoreToDto(Autore autore)
    {
        // System.out.println("Sono dentro AutoreToDto di AutoreMapper");

        AutoreDTO autoreDTO = new AutoreDTO();

        autoreDTO.setId(autore.getId());
        autoreDTO.setNome(autore.getNome());
        autoreDTO.setCognome(autore.getCognome());
        autoreDTO.setLibri(libroMapper.libriToDTOs(autore.getLibri()));

        return autoreDTO;
    }

    public List<AutoreDTO> autoriToDtos(List<Autore> autori)
    {
        List<AutoreDTO> autoriDto = new ArrayList<>();

        for(Autore autore : autori)
        {
            autoriDto.add(autoreToDto(autore));
        }
        return autoriDto;
    }

    public Autore autoreToEntity(AutoreDTO autore)
    {
        System.out.println("sono dentro autoreToEntity");

        Autore autoreEntity = new Autore();

        autoreEntity.setId(autore.getId());
        autoreEntity.setNome(autore.getNome());
        autoreEntity.setCognome(autore.getCognome());
        autoreEntity.setLibri(libroMapper.libriToEntities(autore.getLibri()));

        return autoreEntity;
    }

    public List<Autore> autoriToEntities(List<AutoreDTO> autori)
    {
        List<Autore> listaAutori = new ArrayList<>();

        for(AutoreDTO autore : autori)
        {
            listaAutori.add(autoreToEntity(autore));
        }
        return listaAutori;
    }

}