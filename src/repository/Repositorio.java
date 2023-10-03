package src.repository;

import src.model.Dados;

import java.util.List;

public class Repositorio <T extends Dados>{
    private List<T> dataset;

    public Repositorio(List<T> dataset) {
        this.dataset = dataset;
    }

    public List<T> getDados() {
        return dataset;
    }

}
