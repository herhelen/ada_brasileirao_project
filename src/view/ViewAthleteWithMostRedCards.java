package src.view;

import src.service.ServiceCards;

import java.util.Map;

public class ViewAthleteWithMostRedCards {
    public static void show(ServiceCards service){
        System.out.println("O jogador que mais recebeu cartões vermelhos: ");

        // O jogador que mais recebeu cartões vermelhos
        for (Map.Entry<String, Long> entry: service.getAthleteWithMostRedCards()) {
            System.out.println("Jogador: " + entry.getKey() + " - # Cartões vermelhos: " + entry.getValue());
        }
    }
}
