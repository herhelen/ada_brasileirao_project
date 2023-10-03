package src.service;

import src.model.Dados;
import src.repository.Repositorio;


public abstract class Service<T extends Dados> {

    protected final Repositorio<T> repositorio;

    public Service(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }
}
