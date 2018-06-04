package Repositorios;

import ClassesBasicas.Vem;
import Excecoes.RepositorioVemCheioException;
import Excecoes.VemNaoEncontradoException;

public interface RepositorioVem {
    void inserir(Vem vem) throws RepositorioVemCheioException;
    void remover(String codigo) throws VemNaoEncontradoException;
    void atualizar(Vem vem) throws VemNaoEncontradoException;
    Vem procurar(String codigo) throws VemNaoEncontradoException;
    boolean existe(String codigo);

}
