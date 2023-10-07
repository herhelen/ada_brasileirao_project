package src.service;

import src.model.DadosFull;
import src.repository.Repositorio;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ServiceFull extends Service<DadosFull> {

    public ServiceFull(Repositorio<DadosFull> repositorio) {
        super(repositorio);
    }


    private Supplier<Stream<Map.Entry<String, Long>>> getDadosFullFiltered(Predicate<DadosFull> filter,
                                                                  Function<? super DadosFull, String> function) {

       return () -> this.repositorio
                .getDados().stream()
                // aplica filtro desejado
                .filter(filter)
                // agrupa pela função desejada
                .collect(Collectors.groupingBy(function, Collectors.counting()))
                .entrySet()
                .stream();
    }

    public List<Map.Entry<String, Long>> getTeamWithMostWinsByYear(Integer year) {

        Supplier<Stream<Map.Entry<String, Long>>> baseStream = getDadosFullFiltered(
                dadosFull ->
                        (!dadosFull.getWinner().equalsIgnoreCase("-")) &&
                        (year.equals(dadosFull.getDate().getYear())),
                DadosFull::getWinner
        );

        // Encontra o maior número de vitórias
        Long numberMax = baseStream
                .get()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de times que tenha número de vitórias igual ao maior número de vitórias
        return baseStream
                .get()
                .filter(entry -> numberMax.equals(entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getStateWithLeastMatchByPeriod(Integer startYear, Integer endYear) {

        Supplier<Stream<Map.Entry<String, Long>>> baseStream = getDadosFullFiltered(
                dadosFull ->
                        (dadosFull.getDate().getYear() >= startYear) &&
                        (dadosFull.getDate().getYear() <= endYear),
                DadosFull::getHostState
        );

        // Encontra o menor número de partidas
        Long numberMax = baseStream
                .get()
                .min(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de estados que tenha número de partidas igual ao menor número de partidas
        return baseStream
                .get()
                .filter(entry -> numberMax.equals(entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<DadosFull> getMatchWithMostScore() {

        Integer numberMostScore = this.repositorio
                .getDados().stream()
                .map(dadosFull -> dadosFull.getHostScore() + dadosFull.getVisitorScore())
                .max(Integer::compareTo)
                .orElse(-1);

        return this.repositorio
                .getDados().stream()
                .filter(dadosFull -> dadosFull.getHostScore() + dadosFull.getVisitorScore() == numberMostScore)
                .collect(Collectors.toList());
    }

}
