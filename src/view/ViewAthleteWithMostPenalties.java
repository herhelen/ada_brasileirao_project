package src.view;

import src.service.ServiceGol;

import java.util.List;
import java.util.Map;

public class ViewAthleteWithMostPenalties {
    public static void show(ServiceGol service){
        List<Map.Entry<String, Long>> players = service.getAthleteWithMostPenalties();

        if(players.size() > 1){
            System.out.println("Os jogadores que mais fizeram pênaltis entre 2003 e 2022: ");
        } else {
            System.out.println("O jogador que mais fez pênaltis entre 2003 e 2022: ");
        }

        // O jogador que mais fez gols de pênaltis
        for (Map.Entry<String, Long> entry: players) {
            System.out.println("Jogador: " + entry.getKey() + " - # Pênaltis: " + entry.getValue());
        }
    }
}
