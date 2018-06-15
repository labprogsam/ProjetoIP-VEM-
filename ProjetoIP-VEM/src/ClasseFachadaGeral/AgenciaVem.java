package ClasseFachadaGeral;

import ClassesBasicas.EmpresaVem;
import ClassesBasicas.Pessoa;
import ClassesFachadaIndividual.CadastroEmpresa;
import ClassesFachadaIndividual.CadastroVem;
import ClassesBasicas.Vem;
import Excecoes.*;

public class AgenciaVem {

    private CadastroVem cadastroVem;
    private CadastroEmpresa cadastroEmpresa;
    private CadastroPessoa cadastroPessoa;

    public AgenciaVem(CadastroVem cadastroVem, CadastroEmpresa cadastroEmpresa)
    {
        this.cadastroVem = cadastroVem;
        this.cadastroEmpresa = cadastroEmpresa;
    }

//-------------------------------------------------------------------------------------------------
    //Metodos relacionados diretamente com classe CadastroVem

    public void cadastrarVem(Vem vem, Pessoa pessoa, EmpresaVem empresa) throws EmpresaNaoEncontradaException, VemJaCadastradoException, RepositorioVemCheioException, PessoaNaoEncontradaException
    {
        if(this.cadastroEmpresa.existe((empresa.getCnpj())))
        {
            if(this.cadastroPessoa.existe(pessoa.getCpf()))
            {
                this.cadastroVem.cadastrar(vem);
            }
            else
            {
                throw new PessoaNaoEncontradaException();
            }
        }
        else
        {
            throw new EmpresaNaoEncontradaException();
        }
    }
    public void removerVem(String codigo) throws VemNaoEncontradoException
    {
        this.cadastroVem.remover(codigo);
    }
    public void atualizarVem(Vem vem) throws VemNaoEncontradoException
    {
        this.cadastroVem.atualizar(vem);
    }
    public void procurarVem(String codigo) throws VemNaoEncontradoException
    {
        this.cadastroVem.procurar(codigo);
    }
    public boolean existeVem(String codigo)
    {
        return this.cadastroVem.existe(codigo);
    }
    //Metodo da classe VemEstudantil
    public void renderBonus(String codigo) throws VemNaoEncontradoException, TipoVemInvalidoException, RecargaInvalidaException
    {
        this.cadastroVem.renderBonus(codigo);
    }
    public  void renderBonusFerias(String codigo) throws VemNaoEncontradoException, TipoVemInvalidoException, PeriodoFeriasException
    {
        this.cadastroVem.renderBonusFerias(codigo);
    }


}
