/*
    Record - Entity - Object -> sono la stessa cosa

    HTTP REQUEST: GET (chiedere dei valori)
                  POST (modificare/inserire etc.. valori)

    WEB
         - controller (classe)
         - DTO (oggetti)
    JAVA - service (classe)
         - entity (oggetti)
         - repository (classe)
    DB

        MODI DI RICEVERE VALORI DAL FE
        @RequestBody serve per ricevere interi obj non richiede modifiche nell'URL

        @RequestParam(name = "nome_della_variabile")
        serve per inviare singoli parametri non richiede modifiche nell'URL, rende trasparente l'informazione
        che viene passata: http://localhost:8080/rest/api/v0/getAuthorByName/?nome="ciao"

        @PathVariable serve per inviare singoli parametri, si modifica l'url con un "segnaposto/placeholder" e permette di nascondere
        l'informazione nell'URL: @GetMapping(value = "/getAuthorByName/{nome}")
*/
package it.learnspring.libreria.controller;

import it.learnspring.libreria.dto.*;
import it.learnspring.libreria.service.LibreriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                             // Serve a Spring per capire che classe è (component di Spring).
@RequestMapping(value = "/rest/api/v0")     // Serve per specificare l'indirizzo.
public class LibreriaController {

    @Autowired
    LibreriaService libreriaService;

    @GetMapping(value = "/getHelloWorld")
    public String getHelloWorld(@RequestParam (name = "parola") String parola)
    {
        System.out.println("sono dentro il metodo getHelloWorld()");
        return "Hello World";
    }

    /* ***************************************************************** */
    /*                              LIBRO                                */
    /* ***************************************************************** */

    @GetMapping(value = "/getAllBooks")
    public List<LibroDTO> getAllBooks()
    {
        List<LibroDTO> listaLibri = libreriaService.getAllBooks();
        return listaLibri;
    }

    @GetMapping(value = "/gettAllBooksOrdDesc")
    public List<LibroDTO> getAllBooksOrdered()
    {
        List<LibroDTO> listaLibri = libreriaService.getAllBooksOrdered();
        return listaLibri;
    }

    @GetMapping(value = "/getBookByTitle/{titolo}")
    public LibroDTO getBookByTitle (@PathVariable String titolo)
    {
        if( titolo == null || titolo.isEmpty() )
        {
            return null;
        }

        LibroDTO libroTrovato = libreriaService.getBookByTitle(titolo);
        return libroTrovato;
    }

    @PostMapping(value="/newBook/")
    public String createNewBook(@RequestBody LibroDTO nuovoLibro, @RequestParam (name = "idAutore") Long idAutore)
    {
        if( idAutore == null || idAutore <= 0 )
        {
            return "Il nome dell'autore non può essere nullo!";
        }
        else if ( nuovoLibro == null )
        {
            return "Il libro non può essere nullo!";
        }

        Boolean creationValidation = libreriaService.createNewBook(nuovoLibro, idAutore);

        if(!creationValidation)
        {
            return "La creazione del libro ha riscontrato dei problemi!";
        }
        else
        {
            return "Creazione avvenuta con successo!";
        }
    }

    /* ***************************************************************** */
    /*                              AUTORE                               */
    /* ***************************************************************** */

    @GetMapping(value = "/getAllAuthors")
    public List<AutoreDTO> getAllAuthors()
    {
        System.out.println("Sono dentro l'API del controller");

        List<AutoreDTO> listaAutori = libreriaService.getAllAuthors();
        return listaAutori;

        // 1) chiedere al database la lista di tutti gli utenti (entity)
        // 2) trasformare la lista di entity in lista di DTO
        // 3) restituire la lista di DTO
    }

    @GetMapping(value = "/getAuthorByName/{nome}") // {nome} si chiama "placeholder", si usa ad esempio per richiedere le password, perché le nasconde nell'url.
    public AutoreDTO getAuthorByName (@PathVariable String nome)
    {
       if( nome == null || nome.isEmpty() ) {
           return null;
       }

       AutoreDTO autoreTrovato = libreriaService.getAuthorByName(nome);
       return autoreTrovato;

        // Per passare una singola variabile possiamo usare: @PathVariable o @RequestVariable (controllare anche il metodo gethelloworld).
        // @PathVariable -> si utilizza quando ad esempio dobbiamo richiedere una password in input, perché la nasconde nell'url, non la mostra...
        // @RequestParam ->
    }

    @PostMapping(value="/newAuthor")
    public AutoreDTO createNewAuthor(@RequestBody AutoreDTO nuovoAutore) // Nel controller, quando si parla di cosa restituire al front end si passa il DTO e non la Entity.
    {
        AutoreDTO autoreAppenaInserito = libreriaService.createNewAuthor(nuovoAutore);
        return autoreAppenaInserito;

        // 1) Prendere i valori relativi al nuovo autore dal Front-End
        // 2) Passare i valori del nuovo autore al service
        // 3) Trasforamre il DTO in Entity
        // 4) Salvare la entity sul DB
    }

}