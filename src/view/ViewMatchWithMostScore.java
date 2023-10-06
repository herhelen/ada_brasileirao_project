package src.view;

import src.model.DadosFull;
import src.service.ServiceFull;

import java.util.List;
import java.util.Optional;

public class ViewMatchWithMostScore {
    public static void show(ServiceFull serviceFull){
        List<DadosFull> matches = serviceFull.getMatchWithMostScore();

        Optional<List<DadosFull>> optional = Optional.ofNullable(matches);

        if (optional.isPresent()) {
            if (matches.size() > 1){
                System.out.println("Os placares das partidas com mais gols: ");
            } else {
                System.out.println("O placar da partida com mais gols: ");
            }
            // O placar da partida com mais gols.
            for (DadosFull dadosFull : matches) {
                System.out.println(
                        dadosFull.getHost() +  " " + dadosFull.getHostScore() + " X " +
                                dadosFull.getVisitorScore() + " " + dadosFull.getVisitor());
            }
        } else {
            System.out.println("Não foi possível efetuar a operação.");
        }
    }
}
