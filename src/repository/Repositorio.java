package src.repository;

import src.model.Dados;

import java.util.List;

public class Repositorio <T extends Dados>{
    private List<T> dados;

    public Repositorio(List<T> dados) {
        this.dados = dados;
    }

    public List<T> getDados() {
        return dados;
    }

}
