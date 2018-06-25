package ClassesFachadaIndividual;

import ClassesBasicas.Vem;
import ClassesBasicas.VemEstudantil;
import ClassesBasicas.VemLivre;
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
    public void recarregar(String codigo, double valor) throws VemNaoEncontradoException, RecargaInvalidaException
    {
        Vem vem = this.repositorio.procurar(codigo);
        vem.recarregar(valor);
    }
    public void pagar(String codigo) throws VemNaoEncontradoException, SaldoInsuficienteException
    {
        Vem vem = this.repositorio.procurar(codigo);
        vem.pagar();
    }
    //Metodo da classe vemLivre
    public void recarregarEspecial(String codigo, double valor) throws VemNaoEncontradoException, TipoVemInvalidoException, RecargaInvalidaException
    {
        Vem vemLivre = this.repositorio.procurar(codigo);
        if(vemLivre instanceof VemLivre)
        {
            ((VemLivre)vemLivre).recarregarEspecial(valor);
        }
        else
        {
            throw new TipoVemInvalidoException();
        }
    }
    public void pagarEspecial(String codigo) throws VemNaoEncontradoException, TipoVemInvalidoException, SaldoInsuficienteException
    {
        Vem vemLivre = this.repositorio.procurar(codigo);
        if(vemLivre instanceof VemLivre)
        {
            ((VemLivre) vemLivre).pagarEspecial();
        }
        else
        {
            throw new TipoVemInvalidoException();
        }
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
    //Metodo da classe vemTrabalhador
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
    public void bloquearVem(String codigo) throws VemNaoEncontradoException, BloquearVemException
    {
        Vem vem = this.repositorio.procurar(codigo);
        vem.bloquearVem();
    }
    public void desbloquearVem(String codigo)throws  VemNaoEncontradoException, DesbloquearVemException
    {
        Vem vem = this.repositorio.procurar(codigo);
        vem.desbloquearVem();
    }
    //Metodo da classe VemTrabalhador
    public void entrarFerias(String codigo) throws EntrarFeriasException, VemNaoEncontradoException, TipoVemInvalidoException
    {
        Vem vemTrabalhador = this.repositorio.procurar(codigo);
        if(vemTrabalhador instanceof VemTrabalhador)
        {
            ((VemTrabalhador) vemTrabalhador).entrarFerias();
        }
        else
        {
            throw new TipoVemInvalidoException();
        }

    }
    //Metodo da classe VemTrabalhador
    public void sairFerias(String codigo) throws VemNaoEncontradoException, SairFeriasException, TipoVemInvalidoException
    {
        Vem vemTrabalhador = this.repositorio.procurar(codigo);
        if(vemTrabalhador instanceof VemTrabalhador)
        {
            ((VemTrabalhador) vemTrabalhador).sairFerias();
        }
        else
        {
            throw new TipoVemInvalidoException();
        }
    }
    public String apresentarDados(){
    	return repositorio.relatorio();
    }
}
