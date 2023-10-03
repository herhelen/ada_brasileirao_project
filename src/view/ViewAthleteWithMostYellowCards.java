package src.view;

import src.service.ServiceCards;

import java.util.Map;

public class ViewAthleteWithMostYellowCards {
    public static void show(ServiceCards service){
        System.out.println("O jogador que mais recebeu cartões amarelos entre 2003 e 2022: ");

        // O jogador que mais recebeu cartões amarelos
        for (Map.Entry<String, Long> entry: service.getAthleteWithMostYellowCards()) {
            System.out.println("Jogador: " + entry.getKey() + " - # Cartões amarelos: " + entry.getValue());
        }
    }
}
