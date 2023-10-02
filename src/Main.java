package src;

import src.model.DadosGol;
import src.reading.ReadingCSV;
import src.repository.Repositorio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadingCSV<DadosGol> readerGol = new ReadingCSV<>("data/campeonato-brasileiro-gols.csv");
        List<DadosGol> dadosGol = readerGol.Reading(DadosGol::criarInstancia);
        Repositorio<DadosGol> repositorioGol = new Repositorio<>(dadosGol);


        System.out.println(repositorioGol.getDados().get(0).getAtleta());
    }
}
