package src.view;

import src.service.ServiceFull;
import src.utils.Input;

import java.util.Map;

public class ViewStateWithLeastMatchByPeriod {
    public static void show(ServiceFull service){
        int startYear;
        int endYear;
        boolean verification;

        do {
            verification = true;
            System.out.println("Informe o ano inicial que deseja saber (entre 2003 e 2022): ");
            startYear = Input.getInt();
            System.out.println("Informe o ano final que deseja saber (entre 2003 e 2022): ");
            endYear = Input.getInt();

            if (startYear > 2022 || endYear > 2022 || startYear < 2003 || endYear < 2003){
                System.out.println("Ano inválido!");
                verification = false;
            } else if (endYear < startYear) {
                System.out.println("O ano final deve ser maior que o ano inicial");
                verification = false;
            }
        } while (verification == false);

        // O Estado que teve menos jogos dentro do período 2003 e 2022
        System.out.println("O Estado que menos jogos dentro do período de " + startYear + " e " + endYear + ": ");
        for (Map.Entry<String, Long> entry: service.getStateWithLeastMatchByPeriod(startYear, endYear)) {
            System.out.println("Time: " + entry.getKey() + " - # Vitórias: " + entry.getValue());
        }
    }
}
