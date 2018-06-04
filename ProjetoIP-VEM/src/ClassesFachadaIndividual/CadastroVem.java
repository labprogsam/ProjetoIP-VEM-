package ClassesFachadaIndividual;

import ClassesBasicas.Vem;
import Repositorios.RepositorioVem;

public class CadastroVem {
    private RepositorioVem repositorio;

    public CadastroVem(RepositorioVem repositorio)
    {
        this.repositorio = repositorio;
    }

    public void cadastrar(Vem vem)
    {
        if(!this.repositorio.existe(vem.getCodigo()))
        {
            this.repositorio.inserir(vem);
        }
        else
        {
            //Erro: Vem ja cadastrado
        }
    }
    public void remover(String codigo)
    {
        if(this.repositorio.existe(codigo))
        {
            this.repositorio.remover(codigo);
        }
        else
        {
            //Erro: Vem nao existe
        }
    }
    public void atualizar(Vem vem)
    {
        if(this.repositorio.existe(vem.getCodigo()))
        {
            this.repositorio.atualizar(vem);
        }
        else
        {
            //Erro: Vem nao existe
        }
    }
    public Vem procurar(String codigo)
    {
        if(this.repositorio.existe(codigo))
        {
            return this.repositorio.procurar(codigo);
        }
        else
        {
            //Erro: Vem nao existe
        }
    }
}
