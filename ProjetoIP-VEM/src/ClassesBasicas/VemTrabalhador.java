package ClassesBasicas;

public class VemTrabalhador extends Vem{
    private static final double custoPassagem = 3.2;
    private double bonusFerias;
    private boolean ferias;

    //como o construtor da superclasse exige um codigo, um usuario e uma empresa, é necessario passarmos
    //como parametro aqui tambem.
    public VemTrabalhador(String codigo, Usuario usuario, Empresa empresa)
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
    public void setFerias(boolean ferias)
    {
        this.ferias = ferias;
    }
    //Esse metodo recarrega e tira um custo de 10% do valor a ser recarregado e guarda esse custo no bonus ferias
    //para depois ser creditado no metodo renderBonusFerias
    public void recarregar(double valor)
    {
        double valorDesconto = (valor * 0.1);
        valor -= valorDesconto;
        this.setSaldo(this.getSaldo() + valor);
        this.bonusFerias += valorDesconto;
    }
    //Esse metodo paga a passagem que custa 3.2
    public void pagar()
    {
        double valor = this.getSaldo() - this.custoPassagem;
        this.setSaldo(valor);
    }
    //Esse metodo credita no saldo do vem os valores que foram tirados na hora da recarga, e so poderá ser ultilizado
    //se o usuario do vem estiver de ferias
    public void renderBonusFerias()
    {
        this.setSaldo(this.getSaldo() + this.bonusFerias);
        this.bonusFerias = 0;
    }
}