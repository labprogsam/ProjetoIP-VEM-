package ClassesFachadaIndividual;

import ClassesBasicas.Vem;
import ClassesBasicas.VemEstudantil;
import ClassesBasicas.VemTrabalhador;
import Excecoes.*;
import Repositorios.RepositorioVem;

public class CadastroVem {
    private RepositorioVem repositorio;

    public CadastroVem(RepositorioVem repositorio)
    {
        this.repositorio = repositorio;
    }

    public void cadastrar(Vem vem) throws VemJaCadastradoException, RepositorioVemCheioException
    {
        //Verifica se nao existe um vem com o mesmo codigo antes que ele seja inserido
        if(!this.repositorio.existe(vem.getCodigo()))
        {
            this.repositorio.inserir(vem);
        }
        else
        {
            throw new VemJaCadastradoException(vem.getCodigo());
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
    //Metodo da classe VemEstudantil
    public void renderBonus(String codigo) throws VemNaoEncontradoException, RecargaInvalidaException, TipoVemInvalidoException
    {
        Vem vemEstudantil = this.repositorio.procurar(codigo);
        if(vemEstudantil instanceof VemEstudantil)
        {
            ((VemEstudantil) vemEstudantil).renderBonus();
        }
        else
        {
            throw new TipoVemInvalidoException();
        }
    }
    public void renderBonusFerias(String codigo) throws TipoVemInvalidoException, VemNaoEncontradoException,PeriodoFeriasException
    {
        Vem vemTrabalhador = this.repositorio.procurar(codigo);
        if(vemTrabalhador instanceof VemTrabalhador)
        {
            ((VemTrabalhador) vemTrabalhador).renderBonusFerias();
        }
        else
        {
            throw new TipoVemInvalidoException();
        }
    }
    public void bloquear(String codigo) throws VemNaoEncontradoException, BloquearVemException
    {
        Vem vem = this.repositorio.procurar(codigo);
        vem.bloquearVem();
    }
    public void desbloquear(String codigo)throws  VemNaoEncontradoException, DesbloquearVemException
    {
        Vem vem = this.repositorio.procurar(codigo);
        vem.desbloquearVem();
    }
}
