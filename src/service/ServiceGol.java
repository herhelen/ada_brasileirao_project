package src.service;

import src.model.DadosGol;
import src.repository.Repositorio;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceGol extends Service<DadosGol> {

    public ServiceGol(Repositorio<DadosGol> repositorio) {
        super(repositorio);
    }

    private List<Map.Entry<String, Long>> getAtheleteWithMostSomething(Predicate<DadosGol> filter) {
        Supplier<Stream<Map.Entry<String, Long>>> baseStream = () -> this.repositorio
                .getDados().stream()
                .filter(filter)
                // agrupa pelo nome do jogador e conta número de gols feitos por ele
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream();

        // Encontra o maior número de gols
        Long numberMostGoals = baseStream
                .get()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de jogadores que tenha número de gols igual ao maior número de gols
        return baseStream
                .get()
                .filter(entry -> numberMostGoals.equals(entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostGoals() {
        return getAtheleteWithMostSomething(dadosGol -> true); // não é necessário filtrar
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostPenalties() {
        return getAtheleteWithMostSomething(dadosGol -> "Penalty".equalsIgnoreCase(dadosGol.getTipoDeGol()));
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostOwnGoals() {
        return getAtheleteWithMostSomething(dadosGol -> "Gol Contra".equalsIgnoreCase(dadosGol.getTipoDeGol()));
    }

}
