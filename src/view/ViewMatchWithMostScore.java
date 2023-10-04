package src.view;

import src.model.DadosFull;
import src.service.ServiceFull;

import java.util.List;

public class ViewMatchWithMostScore {
    public static void show(ServiceFull serviceFull){
        List<DadosFull> matches = serviceFull.getMatchWithMostScore();

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
    }
}
