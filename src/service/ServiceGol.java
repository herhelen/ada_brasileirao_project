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
                // agrupa pelo nome do jogador e conta número de gols feitos por ele
                .collect(Collectors.groupingBy(DadosGol::getAtleta, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberMostGoals)
                .collect(Collectors.toList());
    }


}
