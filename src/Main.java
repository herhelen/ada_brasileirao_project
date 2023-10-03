package src;

import src.model.DadosFull;
import src.model.DadosGol;
import src.reading.ReadingCSV;
import src.repository.Repositorio;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        exampleGoalsData();
        exampleFullData();


    }

    static void exampleFullData(){
        ReadingCSV<DadosFull> readerFull = new ReadingCSV<>("data/campeonato-brasileiro-full.csv");
        List<DadosFull> fullData = readerFull.Reading(DadosFull::createInstance);
        Repositorio<DadosFull> fullRepository = new Repositorio<>(fullData);

        System.out.println(fullRepository.getDados().stream().findFirst());

    }
    static void exampleGoalsData(){
        ReadingCSV<DadosGol> readerGol = new ReadingCSV<>("data/campeonato-brasileiro-gols.csv");
        List<DadosGol> goalData = readerGol.Reading(DadosGol::createInstance);
        Repositorio<DadosGol> goalRepository = new Repositorio<>(goalData);


        System.out.println(goalRepository.getDados().get(0).getAtleta());
        System.out.println(goalRepository.getDados().stream()
                .filter(rows -> rows.getRodata().equals("33"))
                .findFirst());
    }
}
