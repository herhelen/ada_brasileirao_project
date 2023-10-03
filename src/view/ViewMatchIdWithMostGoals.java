package src.view;

import src.model.DadosFull;
import src.service.ServiceFull;
import src.service.ServiceGol;

import java.util.List;

public class ViewMatchIdWithMostGoals {
    public static void show(ServiceFull serviceFull, ServiceGol serviceGol){
        List<DadosFull> matches = serviceFull.getMatchScoreById(serviceGol.getMatchIdWithMostGoals());

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
