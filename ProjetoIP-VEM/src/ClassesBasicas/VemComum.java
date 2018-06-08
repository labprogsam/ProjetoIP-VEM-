package ClassesBasicas;

import Excecoes.RecargaInvalidaException;
import Excecoes.SaldoInsuficienteException;

public class VemComum extends Vem {
    private static final double custoPassagem = 3.2;
    public VemComum(String codigo, Pessoa usuario, EmpresaVem empresa)
    {
        super(codigo,usuario,empresa);
    }
    public void recarregar(double valor) throws RecargaInvalidaException
    {
        if(valor >= 0)
        {
            this.setSaldo(this.getSaldo() + valor);
        }
        else
        {
            throw new RecargaInvalidaException();
        }

    }
    public void pagar() throws SaldoInsuficienteException
    {
        if(this.getSaldo() >= this.custoPassagem)
        {
            double valor = this.getSaldo() - this.custoPassagem;
            this.setSaldo(valor);
        }
        else
        {
            throw new SaldoInsuficienteException(this.getSaldo());
        }

    }
}
