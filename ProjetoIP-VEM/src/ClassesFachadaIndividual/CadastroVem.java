package ClassesFachadaIndividual;

import ClassesBasicas.Vem;
import Excecoes.RepositorioVemCheioException;
import Excecoes.VemJaCadastradoException;
import Excecoes.VemNaoEncontradoException;
import Repositorios.RepositorioVem;

public class CadastroVem {
    private RepositorioVem repositorio;

    public CadastroVem(RepositorioVem repositorio)
    {
        this.repositorio = repositorio;
    }

    public void cadastrar(Vem vem) throws VemJaCadastradoException, RepositorioVemCheioException
    {
        if(!this.repositorio.existe(vem.getCodigo()))
        {
            this.repositorio.inserir(vem);
        }
        else
        {
            throw new VemJaCadastradoException();
        }
    }
    public void remover(String codigo) throws VemNaoEncontradoException
    {
        this.repositorio.remover(codigo);
    }
    public void atualizar(Vem vem) throws VemNaoEncontradoException
    {
        this.repositorio.atualizar(vem);
    }
    public Vem procurar(String codigo) throws VemNaoEncontradoException
    {
        return this.repositorio.procurar(codigo);
    }
    public boolean existe(String codigo)
    {
        return this.repositorio.existe(codigo);
    }
}
