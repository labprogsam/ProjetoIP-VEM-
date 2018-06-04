package Repositorios;

import ClassesBasicas.Vem;
import Excecoes.VemNaoEncontradoException;

public class RepositorioVemLista implements RepositorioVem {
    private Vem vem;
    private RepositorioVemLista proximo;

    public RepositorioVemLista()
    {
        this.vem = null;
        this.proximo = null;
    }

    public void inserir(Vem vem)
    {
        if(this.vem == null)
        {
            this.vem = vem;
            this.proximo = new RepositorioVemLista();
        }
        else
        {
            this.proximo.inserir(vem);
        }
    }
    public void remover(String codigo) throws VemNaoEncontradoException
    {
        if(this.existe(codigo))
        {
            if(this.vem.getCodigo().equals(codigo))
            {
                this.vem = this.proximo.vem;
                this.proximo = this.proximo.proximo;
            }
            else
            {
                this.proximo.remover(codigo);
            }
        }
        else
        {
            throw new VemNaoEncontradoException();
        }

    }
    public void  atualizar(Vem vem) throws VemNaoEncontradoException
    {
        if(this.existe(vem.getCodigo()))
        {
            if(this.vem.getCodigo().equals(vem.getCodigo()))
            {
                this.vem = vem;
            }
            else
            {
                this.proximo.atualizar(vem);
            }
        }
        else
        {
            throw new VemNaoEncontradoException();
        }

    }
    public Vem procurar(String codigo) throws VemNaoEncontradoException
    {
        if(this.existe(codigo))
        {
            if(this.vem.getCodigo().equals(codigo))
            {
                return this.vem;
            }
            else
            {
                return this.proximo.procurar(codigo);
            }
        }
        else
        {
            throw new VemNaoEncontradoException();
        }

    }
    public boolean existe(String codigo) {
        if(this.vem == null)
        {
            return false;
        }
        else if(this.vem.getCodigo().equals(codigo))
        {
            return true;
        }
        else
        {
            return this.proximo.existe(codigo);
        }

    }
}
