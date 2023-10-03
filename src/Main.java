package src;

import src.repository.RepositorioSingletons;

public class Main {
    public static void main(String[] args) {

        exampleGoalsData();
        exampleFullData();
        exampleFullStats();
        exampleCards();

    }

    static void exampleCards(){
        System.out.println(RepositorioSingletons.getCardsRepository().getDados().stream().findFirst());
    }

    static void exampleFullStats(){
        System.out.println(RepositorioSingletons.getStatsRepository().getDados().stream().findFirst());
    }

    static void exampleFullData(){
        System.out.println(RepositorioSingletons.getFullRepository().getDados().stream().findFirst());

    }

    static void exampleGoalsData(){
        System.out.println(RepositorioSingletons.getGoalRepository().getDados().get(0).getAtleta());
        System.out.println(RepositorioSingletons.getGoalRepository().getDados().stream()
                .filter(rows -> rows.getRodata().equals("33"))
                .findFirst());
    }
}
