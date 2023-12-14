package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArchivioBibliotecario {
    private List<ElementoDellaBiblioteca> catalogo = new ArrayList<>();

    public void aggiungiElemento(ElementoDellaBiblioteca elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String isbn) {
        catalogo.removeIf(elemento -> elemento.getIsbn().equals(isbn));
    }

    public Optional<ElementoDellaBiblioteca> ricercaPerISBN(String isbn) {
        return catalogo.stream()
                .filter(elemento -> elemento.getIsbn().equals(isbn))
                .findFirst();
    }

    public List<ElementoDellaBiblioteca> ricercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<ElementoDellaBiblioteca> ricercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(elemento -> elemento instanceof Libro && ((Libro) elemento).getAutore().equals(autore))
                .collect(Collectors.toList());
    }


}
