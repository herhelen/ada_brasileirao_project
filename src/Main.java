package src;

import src.repository.RepositorioSingletons;
import src.service.ServiceFull;
import src.service.ServiceGol;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ServiceFull serviceFull = new ServiceFull(RepositorioSingletons.getFullRepository());
        ServiceGol serviceGol = new ServiceGol(RepositorioSingletons.getGoalRepository());

        // O time que mais venceu jogos no ano 2008
        for (Map.Entry<String, Long> entry: serviceFull.getTeamWithMostWinsByYear(2008)) {
            System.out.println("Time: " + entry.getKey() + " - # Vitórias: " + entry.getValue());
        }
        System.out.println();

        // O Estado que teve menos jogos dentro do período 2003 e 2022
        for (Map.Entry<String, Long> entry: serviceFull.getStateWithLeastMatchByPeriod(2003, 2022)) {
            System.out.println("Estado: " + entry.getKey() + " - # Partidas: " + entry.getValue());
        }
        System.out.println();

        // O jogador que mais fez gols
        for (Map.Entry<String, Long> entry: serviceGol.getAthleteWithMostGoals()) {
            System.out.println("Jogador: " + entry.getKey() + " - # Gols: " + entry.getValue());
        }
        System.out.println();

        // O jogador que mais fez gols de pênaltis
        for (Map.Entry<String, Long> entry: serviceGol.getAthleteWithMostPenalties()) {
            System.out.println("Jogador: " + entry.getKey() + " - # Pênaltis: " + entry.getValue());
        }
        System.out.println();

        // O jogador que mais fez gols contras
        for (Map.Entry<String, Long> entry: serviceGol.getAthleteWithMostOwnGoals()) {
            System.out.println("Jogador: " + entry.getKey() + " - # Gols contras: " + entry.getValue());
        }
        System.out.println();

    }


}
