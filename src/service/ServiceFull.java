package src.service;

import src.model.DadosFull;
import src.repository.Repositorio;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        // Encontra o menor número de partidas
        Long numberLeastMatches = this.repositorio
                .getDados().stream()
                // Remove os empates
                .filter(match -> !match.getWinner().equalsIgnoreCase("-"))
                .filter(match -> match.getDate().getYear() >= startYear && match.getDate().getYear() <= endYear)
                // agrupa pelo estado e conta número de partidas
                .collect(Collectors.groupingBy(DadosFull::getHostState, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de estados que tenha número de partidas igual ao menor número de partidas
        return this.repositorio
                .getDados().stream()
                .filter(match -> !match.getWinner().equalsIgnoreCase("-"))
                .filter(match -> match.getDate().getYear() >= startYear && match.getDate().getYear() <= endYear)
                .collect(Collectors.groupingBy(DadosFull::getHostState, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberLeastMatches)
                .collect(Collectors.toList());
    }

    public List<DadosFull> getMatchScoreById(List<Map.Entry<String, Long>> matches) {

        List<String> matchesIds = matches.stream()
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        return this.repositorio.getDados().stream()
                .filter(dadosStatsFull -> matchesIds.contains(dadosStatsFull.getId()))
                .collect(Collectors.toList());
    }
}
