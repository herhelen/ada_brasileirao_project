package src;

import src.repository.RepositorioSingletons;
import src.service.ServiceCards;
import src.service.ServiceFull;
import src.service.ServiceGol;
import src.utils.Input;
import src.view.*;

public class AdaBrasileirao {
    public static void main(String[] args) {

        ServiceFull serviceFull = new ServiceFull(RepositorioSingletons.getFullRepository());
        ServiceGol serviceGol = new ServiceGol(RepositorioSingletons.getGoalRepository());
        ServiceCards serviceCards = new ServiceCards(RepositorioSingletons.getCardsRepository());

        System.out.println("---- ADA BRASILEIRÃO ----");
        String operacao;
        do {
            ViewMenu.showMenu();
            operacao = Input.getString();
            System.out.println();

            switch (operacao) {
                case "1" -> {
                    try {
                        ViewTeamWithMostWinsByYear.show(serviceFull);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "2" -> {
                    try {
                        ViewStateWithLeastMatchByPeriod.show(serviceFull);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "3" -> {
                    try {
                        ViewAthleteWithMostGoals.show(serviceGol);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "4" -> {
                    try {
                        ViewAthleteWithMostPenalties.show(serviceGol);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "5" -> {
                    try {
                        ViewAthleteWithMostOwnGoals.show(serviceGol);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "6" -> {
                    try {
                        ViewAthleteWithMostYellowCards.show(serviceCards);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "7" -> {
                    try {
                        ViewAthleteWithMostRedCards.show(serviceCards);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "8" -> {
                    try {
                        ViewMatchWithMostScore.show(serviceFull);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "0" -> System.out.println("Obrigado pela preferência!");
                default -> System.out.println("Operação inválida!");
            }
        } while (!operacao.equals("0"));

    }

}
