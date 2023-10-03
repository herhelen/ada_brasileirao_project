package src.view;

import src.service.ServiceFull;
import src.utils.Input;

import java.util.List;
import java.util.Map;

public class ViewTeamWithMostWinsByYear {
    public static void show(ServiceFull service){
        int year;

        do {
            System.out.println("Informe o ano que deseja saber (entre 2003 e 2022): ");
            year = Input.getInt();
            if (year > 2022 || year < 2003){
                System.out.println("Ano inválido!");
            }
        } while (year > 2022 || year < 2003);

        List<Map.Entry<String, Long>> players = service.getTeamWithMostWinsByYear(year);

        if (players.size() > 1){
            System.out.println("Os times que mais venceram jogos em " + year + ": ");
        } else {
            System.out.println("O time que mais venceu jogos em " + year + ": ");
        }

        // O time que mais venceu jogos
        for (Map.Entry<String, Long> entry: players) {
            System.out.println("Time: " + entry.getKey() + " - # Vitórias: " + entry.getValue());
        }
    }
}
