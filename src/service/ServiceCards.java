package src.service;

import src.model.DadosCards;
import src.repository.Repositorio;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceCards extends Service<DadosCards> {

    public ServiceCards(Repositorio<DadosCards> repositorio) {
        super(repositorio);
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostYellowCards() {

        // Encontra o maior número de cartões amarelos
        Long numberMostYellowCards = this.repositorio
                .getDados().stream()
                .filter(dadosCards -> dadosCards.getCard().equalsIgnoreCase("Amarelo"))
                // agrupa pelo nome do jogador e conta número de cartões amarelos que ele recebeu
                .collect(Collectors.groupingBy(DadosCards::getAthleteName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de jogadores que tenha número de cartões amarelos igual ao maior número de cartões amarelos
        return this.repositorio
                .getDados().stream()
                .filter(dadosCards -> dadosCards.getCard().equalsIgnoreCase("Amarelo"))
                .collect(Collectors.groupingBy(DadosCards::getAthleteName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberMostYellowCards)
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostRedCards() {

        // Encontra o maior número de cartões vermelhos
        Long numberMostYellowCards = this.repositorio
                .getDados().stream()
                .filter(dadosCards -> dadosCards.getCard().equalsIgnoreCase("Vermelho"))
                // agrupa pelo nome do jogador e conta número de cartões vermelhos que ele recebeu
                .collect(Collectors.groupingBy(DadosCards::getAthleteName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        // Retorna uma lista de jogadores que tenha número de cartões vermelhos igual ao maior número de cartões vermelhos
        return this.repositorio
                .getDados().stream()
                .filter(dadosCards -> dadosCards.getCard().equalsIgnoreCase("Vermelho"))
                .collect(Collectors.groupingBy(DadosCards::getAthleteName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberMostYellowCards)
                .collect(Collectors.toList());
    }
}
