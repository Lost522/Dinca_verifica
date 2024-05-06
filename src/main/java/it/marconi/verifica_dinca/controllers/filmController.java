package it.marconi.verifica_dinca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.marconi.verifica_dinca.domains.Film;
import it.marconi.verifica_dinca.services.FilmService;
import java.util.List;

@Controller
@RequestMapping("/films")
public class filmController { 

    @Autowired
    private FilmService filmService;

    @GetMapping
    public String visualizzaCatalogo(Model model) {
        List<Film> filmCatalogo = filmService.getFilmCatalogo();
        model.addAttribute("filmCatalogo", filmCatalogo);
        model.addAttribute("nuovoFilm", new Film());
        return "catalogo";
    }

    @PostMapping("/nuovo")
    public String aggiungiFilm(@ModelAttribute("nuovoFilm") Film nuovoFilm) {
        filmService.aggiungiFilm(nuovoFilm);
        return "redirect:/films";
    }

    @GetMapping("/{codice}")
    public String visualizzaDettagli(@PathVariable("codice") String codice, Model model) {
        Film film = filmService.trovaFilmPerCodice(codice);
        model.addAttribute("film", film);
        return "dettagli";
    }

    @PostMapping("/{codice}/elimina")
    public String eliminaFilm(@PathVariable("codice") String codice) {
        filmService.eliminaFilm(codice);
        return "redirect:/films";
    }
}





