package org.example;

import org.example.entities.*;

import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        ArchivioBibliotecario archivio = new ArchivioBibliotecario();


        Libro libro = new Libro("123456789", "Il Signore degli Anelli", 1954, 1200, "J.R.R. Tolkien", "Fantasy");
        Rivista rivista = new Rivista("987654321", "National Geographic", 2023, 100, Periodicita.MENSILE);

        archivio.aggiungiElemento(libro);
        archivio.aggiungiElemento(rivista);


        String isbnCercato = "123456789";
        Optional<ElementoDellaBiblioteca> elementoCercato = archivio.ricercaPerISBN(isbnCercato);
        elementoCercato.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Elemento con ISBN " + isbnCercato + " non trovato.")
        );


        int annoRicerca = 1954;
        List<ElementoDellaBiblioteca> libriDel1954 = archivio.ricercaPerAnnoPubblicazione(annoRicerca);
        if (!libriDel1954.isEmpty()) {
            System.out.println("Libri pubblicati nel " + annoRicerca + ":");
            libriDel1954.forEach(System.out::println);
        } else {
            System.out.println("Nessun libro trovato per l'anno " + annoRicerca + ".");
        }

        String autoreRicerca = "J.R.R. Tolkien";
        List<ElementoDellaBiblioteca> libriDiTolkien = archivio.ricercaPerAutore(autoreRicerca);
        if (!libriDiTolkien.isEmpty()) {
            System.out.println("Libri dell'autore " + autoreRicerca + ":");
            libriDiTolkien.forEach(System.out::println);
        } else {
            System.out.println("Nessun libro trovato per l'autore " + autoreRicerca + ".");
        }
    }
}
