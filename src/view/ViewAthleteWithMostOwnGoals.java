package src.view;

import src.service.ServiceGol;

import java.util.Map;

public class ViewAthleteWithMostOwnGoals {
    public static void show(ServiceGol service){
        System.out.println("Jogadores que mais fizeram gols contra entre 2003 e 2022: ");
        // O jogador que mais fez gols contras
        for (Map.Entry<String, Long> entry: service.getAthleteWithMostOwnGoals()) {
            System.out.println("Jogador: " + entry.getKey() + " - # Gols contras: " + entry.getValue());
        }
    }
}
