package ClassesBasicas;

public class VemComum extends Vem {
    private static final double custoPassagem = 3.2;
    public VemComum(String codigo, Pessoa usuario, EmpresaVem empresa)
    {
        super(codigo,usuario,empresa);
    }
    public void recarregar(double valor)
    {
        this.setSaldo(this.getSaldo() + valor);
    }
    public void pagar()
    {
        double valor = this.getSaldo() - this.custoPassagem;
        this.setSaldo(valor);
    }
}
