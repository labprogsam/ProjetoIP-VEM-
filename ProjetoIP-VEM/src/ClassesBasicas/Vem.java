package ClassesBasicas;

import Excecoes.BloquearVemException;
import Excecoes.DesbloquearVemException;
import Excecoes.BloquearVemException;
import Excecoes.RecargaInvalidaException;
import Excecoes.SaldoInsuficienteException;

public abstract class Vem {
    //Esse atributo codigo vai ser o meu idetentificador do Vem
    private String codigo;
    private Pessoa usuario;
    private EmpresaVem empresa;
    private double saldo;
    private boolean ativo;
    //Para ser criado um vem é necessario passar um codigo, um usuario e uma empresa responsavel pela fabricação do vem
    public Vem(String codigo, Pessoa usuario, EmpresaVem empresa)
    {
        this.codigo = codigo;
        this.usuario = usuario;
        this.empresa = empresa;
        this.saldo = 0;
        this.ativo = true;
    }
    public String getCodigo()
    {
        return this.codigo;
    }
    public Pessoa getUsuario() {
        return this.usuario;
    }
    public EmpresaVem getEmpresa()
    {
        return this.empresa;
    }
    public double getSaldo()
    {
        return this.saldo;
    }
    //como as subclasses não vão poder acessar os atributos diretamente, botei um setSaldo para as subclasses
    //poderem modificar o saldo quando implementarem os metodos recarregar e pagar
    protected void setSaldo(double valor)
    {
        this.saldo = valor;
    }
    public boolean getAtivo()
    {
        return this.ativo;
    }
    public void bloquearVem()throws BloquearVemException
    {
        if(this.ativo == true)
        {
            this.ativo = false;
        }
        else
        {
         throw new BloquearVemException();
        }

    }
    public void desbloquearVem() throws DesbloquearVemException
    {
        if(this.ativo == false)
        {
            this.ativo = true;
        }
        else
        {
            throw new DesbloquearVemException();
        }

    }
    public String apresentandoDados() {
    	return "Codigo:" + this.codigo + '\n' + "Nome:" + this.usuario.getNome() + '\n' + "cpf:" + this.usuario.getCpf() + '\n' + "Saldo:" + this.saldo + '\n'+ '\n'; 
    }
    public String apresentandoDados(String cpf) {
    	String dados = "";
    	if(this.usuario.getCpf().equals(cpf))
    		dados += "Codigo:" + this.codigo + '\n' + "Nome:" + this.usuario.getNome() + '\n' + "Saldo:" + this.saldo + '\n' + '\n';
    	return dados;
    }
    //Esses metodos podem ser imprementadoss de forma diferente nas subclasses
    public abstract void recarregar(double valor) throws RecargaInvalidaException;
    public abstract void pagar() throws SaldoInsuficienteException;


}
