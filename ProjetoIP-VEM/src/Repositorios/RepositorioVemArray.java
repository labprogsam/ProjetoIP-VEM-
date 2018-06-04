package Repositorios;

import ClassesBasicas.Vem;

public class RepositorioVemArray implements RepositorioVem{
    private Vem[] arrayVem;
    private int indice;

    public RepositorioVemArray()
    {
        this.arrayVem = new Vem[100];
        this.indice = 0;
    }

    public void inserir(Vem vem)
    {
        this.arrayVem[this.indice] = vem;
        this.indice++;
    }
    public void remover(String codigo)
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
            }
        }

    }
    public void atualizar(Vem vem)
    {
        boolean atualizou = false;
        for(int i = 0; i < this.indice && !atualizou; i++)
        {
            if(this.arrayVem[i].getCodigo().equals(vem.getCodigo()))
            {
                arrayVem[i] = vem;
                atualizou = true;
            }
        }
    }
    public Vem procurar(String codigo)
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
}
