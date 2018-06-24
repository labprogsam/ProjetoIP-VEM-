package ClasseFachadaGeral;

import ClassesBasicas.EmpresaVem;
import ClassesBasicas.Pessoa;
import ClassesFachadaIndividual.*;
import ClassesBasicas.Vem;
import Excecoes.*;

public class AgenciaVem {

    private CadastroVem cadastroVem;
    private CadastroEmpresa cadastroEmpresa;
    private CadastroPessoa cadastroPessoa;

    public AgenciaVem(CadastroVem cadastroVem, CadastroEmpresa cadastroEmpresa, CadastroPessoa cadastroPessoa)
    {
        this.cadastroVem = cadastroVem;
        this.cadastroEmpresa = cadastroEmpresa;
        this.cadastroPessoa = cadastroPessoa;
    }

//-------------------------------------------------------------------------------------------------
    //Metodos relacionados diretamente com classe CadastroVem

    public void cadastrarVem(Vem vem, Pessoa pessoa, EmpresaVem empresa) throws EmpresaNaoEncontradaException, VemJaCadastradoException, RepositorioVemCheioException, PessoaNaoEncontradaException
    {
        if(this.cadastroEmpresa.existeEmpresa((empresa.getCnpj())))
        {
            if(this.cadastroPessoa.verificarExistenciaCadastro(pessoa.getCpf()))
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
    public Vem procurarVem(String codigo) throws VemNaoEncontradoException
    {
        return this.cadastroVem.procurar(codigo);
    }
    public boolean existeVem(String codigo)
    {
        return this.cadastroVem.existe(codigo);
    }
    public void recarregar(String codigo, double valor) throws VemNaoEncontradoException, RecargaInvalidaException
    {
        this.cadastroVem.recarregar(codigo,valor);
    }
    public void pagar(String codigo) throws VemNaoEncontradoException, SaldoInsuficienteException
    {
        this.cadastroVem.pagar(codigo);
    }
    //Metodo da classe VemLivre
    public void recarregarEspecial(String codigo, double valor) throws VemNaoEncontradoException, RecargaInvalidaException, TipoVemInvalidoException
    {
        this.cadastroVem.recarregarEspecial(codigo,valor);
    }
    //Metodo da classe VemLivre
    public void pagarEspecial(String codigo) throws VemNaoEncontradoException, SaldoInsuficienteException, TipoVemInvalidoException
    {
        this.cadastroVem.pagarEspecial(codigo);
    }
    //Metodo da classe VemEstudantil
    public void renderBonus(String codigo) throws VemNaoEncontradoException, TipoVemInvalidoException, RecargaInvalidaException
    {
        this.cadastroVem.renderBonus(codigo);
    }
    //Metodo da classe vemTrabalhador
    public  void renderBonusFerias(String codigo) throws VemNaoEncontradoException, TipoVemInvalidoException, PeriodoFeriasException
    {
        this.cadastroVem.renderBonusFerias(codigo);
    }
    public void bloquearVem(String codigo) throws VemNaoEncontradoException, BloquearVemException
    {
        this.cadastroVem.bloquearVem(codigo);
    }
    public void desbloquearVem(String codigo) throws VemNaoEncontradoException, DesbloquearVemException
    {
        this.cadastroVem.desbloquearVem(codigo);
    }
    //Metodo da classe vemTrabalhador
    public void entrarFerias(String codigo) throws VemNaoEncontradoException, EntrarFeriasException, TipoVemInvalidoException
    {
        this.cadastroVem.entrarFerias(codigo);
    }
    //Metodo da classe VemTrabalhador
    public void sairFerias(String codigo) throws VemNaoEncontradoException, SairFeriasException, TipoVemInvalidoException
    {
        this.cadastroVem.sairFerias(codigo);
    }
    
    
    //-------------------------------------------------------------------------------------------------
    //Metodos relacionados diretamente com classe CadastroEmpresa
    
    //Metodo relacionados ao Repositorio
    public void cadastrarEmpresa (EmpresaVem empresa) throws EmpresaJaCadastradaException, RepositorioEmpresaCheioException 
    {
    	this.cadastroEmpresa.cadastrarEmpresa(empresa);
    }
    //Metodo relacionados ao Repositorio
    public void removerEmpresa (String cnpj) throws EmpresaNaoEncontradaException  
    {
		this.cadastroEmpresa.removerEmpresa(cnpj);
	}
    //Metodo relacionados ao Repositorio
    public void atualizarEmpresaEmpresa(EmpresaVem empresa) throws EmpresaNaoEncontradaException 
    {
    	this.cadastroEmpresa.atualizarEmpresa(empresa);
    }
    //Metodo relacionados ao Repositorio
    public boolean existeEmpresa (String cnpj) 
    {
    	return this.cadastroEmpresa.existeEmpresa(cnpj);
    }
    //Metodo relacionados ao Repositorio
	public EmpresaVem procurarEmpresa (String cnpj) throws EmpresaNaoEncontradaException 
	{
		return this.cadastroEmpresa.procurarEmpresa(cnpj);
	}
	
//-------------------------------------------------------------------------------------------------
//Metodos relacionados diretamente com classe CadastroPessoa	
    public void cadastrarPessoa (Pessoa pessoa) throws PessoaJaCadastradaException, RepositorioPessoaCheioException, PessoaNaoEncontradaException 
    {
    	this.cadastroPessoa.inserir(pessoa);
    }
    
    public void removerPessoa (String cpf) throws PessoaNaoEncontradaException  
    {
		this.cadastroPessoa.excluir(cpf);
	}
    
    public void atualizarEmpresaPessoa(Pessoa pessoa) throws PessoaNaoEncontradaException 
    {
    	this.cadastroPessoa.atualizarCadastro(pessoa);
    }
    
    public boolean existePessoa (String cpf) throws PessoaNaoEncontradaException 
    {
    	return this.cadastroPessoa.verificarExistenciaCadastro(cpf);
    }
    
	public Pessoa procurarPessoa (String cpf) throws PessoaNaoEncontradaException 
	{
		return this.cadastroPessoa.retornarPessoa(cpf);
	} 


}
