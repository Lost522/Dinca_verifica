package it.marconi.verifica_dinca.services;


import org.springframework.stereotype.Service;

import it.marconi.verifica_dinca.domains.Film;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {
    
    private List<Film> filmCatalogo = new ArrayList<>();

    public List<Film> getFilmCatalogo() {
        return filmCatalogo;
    }
    public void aggiungiFilm(Film film) {
        filmCatalogo.add(film);
    }
    
    public void svuotaCatalogo() {
        filmCatalogo.clear();
    }
    
    public void eliminaFilm(String codice) {
        filmCatalogo.removeIf(film -> film.getCodice().equals(codice));
    }
    
    public Film trovaFilmPerCodice(String codice) {
        return filmCatalogo.stream()
                .filter(film -> film.getCodice().equals(codice))
                .findFirst()
                .orElse(null);
    }
    

    
}





