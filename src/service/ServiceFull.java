package src.service;

import src.model.DadosFull;
import src.repository.Repositorio;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceFull extends Service<DadosFull> {

    public ServiceFull(Repositorio<DadosFull> repositorio) {
        super(repositorio);
    }

    public List<Map.Entry<String, Long>> getTeamWithMostWinsByYear(Integer year) {

        // Encontra o maior número de vitórias
        Long numberMostWins = this.repositorio
                .getDados().stream()
                // Remove os empates
                .filter(match -> !match.getWinner().equalsIgnoreCase("-"))
                .filter(match -> match.getDate().getYear() == year)
                // agrupa pelo nome do time vencedor e conta número de vitórias
                .collect(Collectors.groupingBy(DadosFull::getWinner, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de times que tenha número de vitórias igual ao maior número de vitórias
        return this.repositorio
                .getDados().stream()
                .filter(match -> !match.getWinner().equalsIgnoreCase("-"))
                .filter(match -> match.getDate().getYear() == year)
                .collect(Collectors.groupingBy(DadosFull::getWinner, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberMostWins)
                .collect(Collectors.toList());
    }


    public List<Map.Entry<String, Long>> getStateWithLeastMatchByPeriod(Integer startYear, Integer endYear) {

        Supplier<Stream<Map.Entry<String, Long>>> baseStream = () -> this.repositorio
                .getDados().stream()
                .filter(match -> match.getDate().getYear() >= startYear && match.getDate().getYear() <= endYear)
                .collect(Collectors.groupingBy(DadosFull::getHostState, Collectors.counting()))
                .entrySet()
                .stream();

        // Find min Matches
        Long numberLeastMatches = baseStream
                .get()
                .min(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de estados que tenha número de partidas igual ao menor número de partidas
        return baseStream
                .get()
                .filter(entry -> entry.getValue() == numberLeastMatches)
                .collect(Collectors.toList());
    }

    public List<DadosFull> getMatchWithMostScore() {

        Optional<Integer> numberMostScore = this.repositorio
                .getDados().stream()
                .map(dadosFull -> dadosFull.getHostScore() + dadosFull.getVisitorScore())
                .max(Integer::compareTo);

        if (numberMostScore.isPresent()) {

            return this.repositorio
                    .getDados().stream()
                    .filter(dadosFull -> dadosFull.getHostScore() + dadosFull.getVisitorScore() == numberMostScore.get())
                    .collect(Collectors.toList());
        }

        return null;
    }
}
