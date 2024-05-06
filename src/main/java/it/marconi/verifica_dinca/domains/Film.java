package it.marconi.verifica_dinca.domains;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    
    private String codice;
    private String titolo;
    private String genere;
    private int anno;
    private int voto;
}




