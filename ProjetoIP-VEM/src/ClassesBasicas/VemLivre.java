package ClassesBasicas;

import Excecoes.RecargaInvalidaException;
import Excecoes.SaldoInsuficienteException;

public class VemLivre extends Vem{
	private static final double valorPassagem = 1.6;
	private double saldoEspecial;
	
	public VemLivre(String codigo, Pessoa usuario, EmpresaVem empresa) {
		super(codigo, usuario, empresa);
		this.saldoEspecial = 0;
	}
	public void recarregarEspecial(double valor) throws RecargaInvalidaException{
		if(valor > 0) {
			this.saldoEspecial += valor;
		}else {
			throw new RecargaInvalidaException();
		}
	}
	public void pagarEspecial() throws SaldoInsuficienteException{
		if(this.saldoEspecial >= this.valorPassagem) {
			this.saldoEspecial -= this.valorPassagem; 
		}else {
			throw new SaldoInsuficienteException(this.saldoEspecial);
		}
	}
	public double getSaldoEspecial() {
		return this.saldoEspecial;
	}
	public void recarregar(double valor) throws RecargaInvalidaException {
		if(valor > 0) {
			this.setSaldo(this.getSaldo() + valor); 
		}else {
			throw new RecargaInvalidaException();
		}
	}
	public void pagar() throws SaldoInsuficienteException {
		if(this.getSaldo() >= this.valorPassagem) {
			this.setSaldo(this.getSaldo() - this.valorPassagem); 
		}else {
			throw new SaldoInsuficienteException(this.getSaldo());
		}
	}
}
