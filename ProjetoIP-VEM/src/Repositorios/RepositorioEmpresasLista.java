package Repositorios;

import ClassesBasicas.EmpresaVem;
import Excecoes.EmpresaJaCadastradaException;
import Excecoes.EmpresaNaoEncontradaException;

public class RepositorioEmpresasLista implements InterfaceRepositorioEmpresa {
	private EmpresaVem empresa;
	private RepositorioEmpresasLista proximo;

	public void inserir(EmpresaVem empresa) throws EmpresaJaCadastradaException {

		if (this.empresa == null) {
			this.empresa = empresa;
			this.proximo = new RepositorioEmpresasLista();

		} else if (this.empresa.getCnpj().equals(empresa.getCnpj())) {
			throw new EmpresaJaCadastradaException();

		} else {
			this.proximo.inserir(empresa);
		}
	}

	public void remover(String cnpj) throws EmpresaNaoEncontradaException {
		if (this.empresa == null) {
			throw new EmpresaNaoEncontradaException();

		} else if (this.empresa.getCnpj().equals(cnpj)) {
			this.empresa = this.proximo.empresa;
			this.proximo = this.proximo.proximo;
		} else {
			this.proximo.remover(cnpj);
		}
	}

	public void atualizarEmpresa(EmpresaVem empresa) throws EmpresaNaoEncontradaException {

		if (this.empresa == null) {
			throw new EmpresaNaoEncontradaException();
		} else if (this.empresa.getCnpj().equals(empresa.getCnpj())) {
			this.empresa = empresa;
		} else {
			this.proximo.atualizarEmpresa(empresa);
		}
	}

	public boolean existe(String cnpj) {
		if (this.empresa == null) {
			return false;
		} else if (this.empresa.getCnpj().equals(cnpj)) {
			return true;
		} else {
			return this.proximo.existe(cnpj);
		}
	}

	public EmpresaVem procurar(String cnpj) throws EmpresaNaoEncontradaException {
		
		if (this.empresa == null) {
			throw new EmpresaNaoEncontradaException();
		} else if (this.empresa.getCnpj().equals(cnpj)) {
			return this.empresa;
		} else {
			return this.proximo.procurar(cnpj);
		}

	}

}
