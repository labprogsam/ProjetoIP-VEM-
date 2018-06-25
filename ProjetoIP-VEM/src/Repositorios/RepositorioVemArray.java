package Repositorios;

import ClassesBasicas.Vem;
import Excecoes.RepositorioVemCheioException;
import Excecoes.VemNaoEncontradoException;

public class RepositorioVemArray implements RepositorioVem{
    private Vem[] arrayVem;
    private int indice;
    
    public RepositorioVemArray()
    {
        this.arrayVem = new Vem[100];
        this.indice = 0;
    }

    public void inserir(Vem vem) throws RepositorioVemCheioException
    {
        if(this.indice < this.arrayVem.length)
        {
            this.arrayVem[this.indice] = vem;
            this.indice++;
        }
        else
        {
            throw new RepositorioVemCheioException();
        }

    }
    public void remover(String codigo) throws VemNaoEncontradoException
    {
        if(this.existe(codigo))
        {
            boolean removeu = false;
            for(int i =0; i < this.indice && !removeu; i++)
            {
                if(this.arrayVem[i].getCodigo().equals(codigo))
                {
                    this.arrayVem[i] = null;
                    removeu = true;
                    for(int j = i; j < this.indice - 1; j++)
                    {
                        if(this.arrayVem[j] == null)
                        {
                            Vem aux = this.arrayVem[j];
                            this.arrayVem[j] = this.arrayVem[j+1];
                            this.arrayVem[j+1] = aux;
                        }
                    }
                    this.indice--;
                }
            }
        }
        else
        {
            throw new VemNaoEncontradoException();
        }
    }
    public void atualizar(Vem vem) throws VemNaoEncontradoException
    {
        if(this.existe(vem.getCodigo()))
        {
            boolean atualizou = false;
            for(int i = 0; i < this.indice && !atualizou; i++)
            {
                if(this.arrayVem[i].getCodigo().equals(vem.getCodigo()))
                {
                    this.arrayVem[i] = vem;
                    atualizou = true;
                }
            }
        }
        else
        {
            throw new VemNaoEncontradoException();
        }
    }
    public Vem procurar(String codigo) throws VemNaoEncontradoException
    {
        boolean achou = false;
        Vem resposta = null;
        for(int i = 0; i < this.indice && !achou; i++)
        {
            if(this.arrayVem[i].getCodigo().equals(codigo))
            {
                resposta = arrayVem[i];
                achou = true;
            }
        }
        if(!achou)
        {
            throw new VemNaoEncontradoException();
        }
        return resposta;
    }
    public boolean existe(String codigo)
    {
        boolean achou = false;
        for(int i = 0; i < this.indice && !achou; i++)
        {
            if(this.arrayVem[i].getCodigo().equals(codigo))
            {
                achou = true;
            }
        }
        return achou;
    }

	public String relatorio() {
		String resultado = "";
		for(int i = 0; i < indice; i++) {
			this.arrayVem[i].apresentandoDados();
		}
		return resultado;
	}
}
