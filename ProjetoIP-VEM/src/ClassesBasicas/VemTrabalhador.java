package ClassesBasicas;

import Excecoes.*;

public class VemTrabalhador extends Vem{
    private static final double custoPassagem = 3.2;
    private double bonusFerias;
    private boolean ferias;

    //como o construtor da superclasse exige um codigo, um usuario e uma empresa, é necessario passarmos
    //como parametro aqui tambem.
    public VemTrabalhador(String codigo, Pessoa usuario, EmpresaVem empresa)
    {
        super(codigo,usuario,empresa);
        this.bonusFerias = 0;
        this.ferias = false;
    }
    public double getBonusFerias()
    {
        return this.bonusFerias;
    }
    public boolean getFerias()
    {
        return this.ferias;
    }
    public void entrarFerias() throws EntrarFeriasException
    {
        if(this.ferias == false)
        {
            this.ferias = true;
        }
        else
        {
            throw new EntrarFeriasException();
        }
    }
    public void sairFerias() throws SairFeriasException
    {
        if(this.ferias == true)
        {
            this.ferias = false;
        }
        else
        {
            throw new SairFeriasException();
        }

    }
    //Esse metodo recarrega e tira um custo de 10% do valor a ser recarregado e guarda esse custo no bonus ferias
    //para depois ser creditado no metodo renderBonusFerias
    public void recarregar(double valor) throws RecargaInvalidaException
    {
        if(valor >= 0)
        {
            double valorDesconto = (valor * 0.1);
            valor -= valorDesconto;
            this.setSaldo(this.getSaldo() + valor);
            this.bonusFerias += valorDesconto;
        }
        else
        {
            throw new RecargaInvalidaException();
        }

    }
    //Esse metodo paga a passagem que custa 3.2
    public void pagar() throws SaldoInsuficienteException
    {
        if(this.getSaldo() >= this.custoPassagem)
        {
            double valor = this.getSaldo() - this.custoPassagem;
            this.setSaldo(valor);
        }
        else
        {
            throw new SaldoInsuficienteException(getSaldo());
        }

    }
    //Esse metodo credita no saldo do vem os valores que foram tirados na hora da recarga, e so poderá ser ultilizado
    //se o usuario do vem estiver de ferias
    public void renderBonusFerias() throws PeriodoFeriasException
    {
        if(this.getFerias())
        {
            this.setSaldo(this.getSaldo() + this.bonusFerias);
            this.bonusFerias = 0;
        }
        else
        {
            throw new PeriodoFeriasException();
        }
    }
}
