package src;

import src.repository.RepositorioSingletons;
import src.service.ServiceFull;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ServiceFull serviceFull = new ServiceFull(RepositorioSingletons.getFullRepository());

        // O time que mais venceu jogos no ano 2008
        for (Map.Entry<String, Long> entry: serviceFull.getTeamWithMostWinsByYear(2008)) {
            System.out.println("Time: " + entry.getKey() + " - Vitórias: " + entry.getValue());
        }



    }


}
