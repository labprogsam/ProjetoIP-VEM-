package ClassesBasicas;

public class VemEstudantil extends Vem {
    private static final double custoPassagem = 1.6;
    private int viagens;
    private double bonus;
    //como o construtor da superclasse exige um codigo, um usuario e uma empresa, é necessario passarmos
    //como parametro aqui tambem.
    public VemEstudantil(String codigo, Usuario usuario, Empresa empresa)
    {
        super(codigo,usuario,empresa);
        this.viagens = 0;
        this.bonus = 0;
    }
    public int getViagens()
    {
        return this.viagens;
    }
    public double getBonus()
    {
        return this.bonus;
    }
    //implementação do metodo abstrato recarregar
    public void recarregar(double valor)
    {
        this.setSaldo(this.getSaldo() + valor);
    }
    //implementação do metodo abstrato pagar
    public void pagar()
    {
        this.viagens += 1;
        double valor = this.getSaldo() - this.custoPassagem;
        this.setSaldo(valor);
    }
    //O metodo render bonus acrescenta no saldo um valor que depende de quantas viagens o vem fez
    public void renderBonus()
    {
        double valor = this.viagens * 0.2;
        this.recarregar(valor);
        this.viagens = 0;
    }


}
