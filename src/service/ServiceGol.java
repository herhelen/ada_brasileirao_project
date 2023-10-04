package src.service;

import src.model.DadosGol;
import src.repository.Repositorio;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceGol extends Service<DadosGol> {

    public ServiceGol(Repositorio<DadosGol> repositorio) {
        super(repositorio);
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostGoals() {

        // Encontra o maior número de gols
        Long numberMostGoals = this.repositorio
                .getDados().stream()
                // agrupa pelo nome do jogador e conta número de gols feitos por ele
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de jogadores que tenha número de gols igual ao maior número de gols
        return this.repositorio
                .getDados().stream()
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberMostGoals)
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostPenalties() {

        // Encontra o maior número de pênaltis
        Long numberMostPenalties = this.repositorio
                .getDados().stream()
                // filtra apenas gols do tipo pênalti
                .filter(dadosGol -> dadosGol.getTipoDeGol().equalsIgnoreCase("Penalty"))
                // agrupa pelo nome do jogador e conta número de pênaltis
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de jogadores que tenha número de pênaltis igual ao maior número de pênaltis
        return this.repositorio
                .getDados().stream()
                .filter(dadosGol -> dadosGol.getTipoDeGol().equalsIgnoreCase("Penalty"))
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberMostPenalties)
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostOwnGoals() {

        // Encontra o maior número de gols contras
        Long numberMostOwnGoals = this.repositorio
                .getDados().stream()
                // filtra apenas gols do tipo gol contra
                .filter(dadosGol -> dadosGol.getTipoDeGol().equalsIgnoreCase("Gol Contra"))
                // agrupa pelo nome do jogador e conta número de gols contras
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de jogadores que tenha número de gols contras igual ao maior número de gols contras
        return this.repositorio
                .getDados().stream()
                .filter(dadosGol -> dadosGol.getTipoDeGol().equalsIgnoreCase("Gol Contra"))
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberMostOwnGoals)
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getMatchIdWithMostGoals() {

        // Encontra o maior número de gols
        Long numberMostGoals = this.repositorio
                .getDados().stream()
                // agrupa pelo id da partida e conta número de gols total
                .collect(Collectors.groupingBy(DadosGol::getPartidaId, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de id de partidas que tenha número de gols igual ao maior número de gols
        return this.repositorio
                .getDados().stream()
                .collect(Collectors.groupingBy(DadosGol::getPartidaId, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberMostGoals)
                .collect(Collectors.toList());
    }
}
