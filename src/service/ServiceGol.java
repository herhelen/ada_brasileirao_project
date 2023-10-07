package src.service;

import src.model.DadosGol;
import src.repository.Repositorio;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceGol extends Service<DadosGol> {

    public ServiceGol(Repositorio<DadosGol> repositorio) {
        super(repositorio);
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostGoals() {

        Supplier<Stream<Map.Entry<String, Long>>> baseStream = () -> this.repositorio
                .getDados().stream()
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
                .filter(entry -> entry.getValue() == numberMostGoals)
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostPenalties() {

        Supplier<Stream<Map.Entry<String, Long>>> baseStream = () -> this.repositorio
                .getDados().stream()
                // filtra apenas gols do tipo pênalti
                .filter(dadosGol -> dadosGol.getTipoDeGol().equalsIgnoreCase("Penalty"))
                // agrupa pelo nome do jogador e conta número de pênaltis
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream();

        // Encontra o maior número de pênaltis
        Long numberMostPenalties = baseStream
                .get()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de jogadores que tenha número de pênaltis igual ao maior número de pênaltis
        return baseStream
                .get()
                .filter(entry -> entry.getValue() == numberMostPenalties)
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostOwnGoals() {

        Supplier<Stream<Map.Entry<String, Long>>> baseStream = () -> this.repositorio
                .getDados().stream()
                // filtra apenas gols do tipo gol contra
                .filter(dadosGol -> dadosGol.getTipoDeGol().equalsIgnoreCase("Gol Contra"))
                // agrupa pelo nome do jogador e conta número de gols contras
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream();

        // Encontra o maior número de gols contras
        Long numberMostOwnGoals = baseStream
                .get()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de jogadores que tenha número de gols contras igual ao maior número de gols contras
        return baseStream
                .get()
                .filter(entry -> entry.getValue() == numberMostOwnGoals)
                .collect(Collectors.toList());
    }

}
