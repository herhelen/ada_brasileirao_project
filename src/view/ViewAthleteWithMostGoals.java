package src.view;

import src.service.ServiceGol;

import java.util.Map;

public class ViewAthleteWithMostGoals{
    public static void show(ServiceGol service){
        // O jogador que mais fez gols
        System.out.println("O jogador que mais fez gols entre 2003 e 2022: ");
        for (Map.Entry<String, Long> entry: service.getAthleteWithMostGoals()) {
            System.out.println(entry.getKey() + " - # Gols: " + entry.getValue());
        }
    }
}
