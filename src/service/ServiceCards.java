package src.service;

import src.model.DadosCards;
import src.repository.Repositorio;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceCards extends Service<DadosCards> {

    public ServiceCards(Repositorio<DadosCards> repositorio) {
        super(repositorio);
    }

    private List<Map.Entry<String, Long>> getAtheleteWithMostCards(Predicate<DadosCards> filter) {
        Supplier<Stream<Map.Entry<String, Long>>> baseStream = () -> this.repositorio
                .getDados().stream()
                .filter(filter)
                // agrupa pelo nome do jogador e conta número de cartões que ele recebeu
                .collect(Collectors.groupingBy(DadosCards::getAthleteName, Collectors.counting()))
                .entrySet()
                .stream();

        Long maxCards = baseStream
                .get()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        return baseStream
                .get()
                .filter(entry -> maxCards.equals(entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostYellowCards() {
        return getAtheleteWithMostCards(dadosCards -> "Amarelo".equalsIgnoreCase(dadosCards.getCard()));
    }

    public List<Map.Entry<String, Long>> getAthleteWithMostRedCards() {
        return getAtheleteWithMostCards(dadosCards -> "Vermelho".equalsIgnoreCase(dadosCards.getCard()));
    }
}
