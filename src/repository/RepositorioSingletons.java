package src.repository;

import src.model.DadosCards;
import src.model.DadosFull;
import src.model.DadosGol;
import src.model.DadosStatsFull;
import src.reading.ReadingCSV;

import java.util.List;

public final class RepositorioSingletons {

    private static Repositorio<DadosCards> cardsRepository;
    private static Repositorio<DadosStatsFull> statsRepository;
    private static Repositorio<DadosFull> fullRepository;
    private static Repositorio<DadosGol> goalRepository;

    public static Repositorio<DadosCards> getCardsRepository() {
        if(cardsRepository == null) {
            ReadingCSV<DadosCards> reader = new ReadingCSV<>("data/campeonato-brasileiro-cartoes.csv");
            List<DadosCards> cardsData = reader.Reading(DadosCards::createInstance);
            cardsRepository = new Repositorio<>(cardsData);
        }
        return cardsRepository;
    }

    public static Repositorio<DadosStatsFull> getStatsRepository() {
        if(statsRepository == null) {
            ReadingCSV<DadosStatsFull> reader = new ReadingCSV<>("data/campeonato-brasileiro-estatisticas-full.csv");
            List<DadosStatsFull> statsData = reader.Reading(DadosStatsFull::createInstance);
            statsRepository = new Repositorio<>(statsData);
        }
        return statsRepository;
    }

    public static Repositorio<DadosFull> getFullRepository() {
        if(fullRepository == null) {
            ReadingCSV<DadosFull> readerFull = new ReadingCSV<>("data/campeonato-brasileiro-full.csv");
            List<DadosFull> fullData = readerFull.Reading(DadosFull::createInstance);
            fullRepository = new Repositorio<>(fullData);
        }
        return fullRepository;
    }

    public static Repositorio<DadosGol> getGoalRepository() {
        if(goalRepository == null) {
            ReadingCSV<DadosGol> readerGol = new ReadingCSV<>("data/campeonato-brasileiro-gols.csv");
            List<DadosGol> goalData = readerGol.Reading(DadosGol::createInstance);
            goalRepository = new Repositorio<>(goalData);
        }
        return goalRepository;
    }
}
