package Repositorios;

import ClassesBasicas.Vem;

public interface RepositorioVem {
    void inserir(Vem vem);
    void remover(String codigo);
    void atualizar(Vem vem);
    Vem procurar(String codigo);
    boolean existe(String codigo);

}
