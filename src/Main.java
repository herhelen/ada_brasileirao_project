package src;

import src.model.DadosCards;
import src.model.DadosFull;
import src.model.DadosGol;
import src.model.DadosStatsFull;
import src.reading.ReadingCSV;
import src.repository.Repositorio;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        exampleGoalsData();
        exampleFullData();
        exampleFullStats();
        exampleCards();

    }

    static void exampleCards(){
        ReadingCSV<DadosCards> reader = new ReadingCSV<>("data/campeonato-brasileiro-cartoes.csv");
        List<DadosCards> cardsData = reader.Reading(DadosCards::createInstance);
        Repositorio<DadosCards> cardsRepository = new Repositorio<>(cardsData);

        System.out.println(cardsRepository.getDados().stream().findFirst());
    }

    static void exampleFullStats(){
        ReadingCSV<DadosStatsFull> reader = new ReadingCSV<>("data/campeonato-brasileiro-estatisticas-full.csv");
        List<DadosStatsFull> statsData = reader.Reading(DadosStatsFull::createInstance);
        Repositorio<DadosStatsFull> statsRepository = new Repositorio<>(statsData);

        System.out.println(statsRepository.getDados().stream().findFirst());
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
