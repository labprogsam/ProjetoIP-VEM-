package Repositorios;

import Excecoes.EmpresaNaoEncontradaException;

import BasicClassEmpresa.EmpresaVem;

public class RepositorioEmpresaArray implements InterfaceRepositorioEmpresa {
	private EmpresaVem[] contas;
	private int indice;

	// Constructor
	public RepositorioEmpresaArray() {
		this.contas = new EmpresaVem[10];
		this.indice = 0;
	}

	public void inserir(EmpresaVem empresa) {
		this.contas[this.indice] = empresa;
		this.indice++;
	}

	public void remover(String cnpj) throws EmpresaNaoEncontradaException {
		if (this.existe(cnpj) == true) {
			for (int i = 0; i < this.indice; i++) {
				if (this.contas[i].getCnpj().equals(cnpj)) {
					this.contas[i] = null;
					this.indice--;
				}
			}

			// Esse for servirá para organizar o array após algum elemento ser retirado.
			for (int i = 0; i < this.indice; i++) {
				if (this.contas[i] == null && this.contas[i + 1] != null) {
					this.contas[i] = contas[i + 1];
				}
			}

			this.indice--;

		} else {
			throw new EmpresaNaoEncontradaException();
		}

	}

	// Esse método tem como objetivo atualizar as informações de alguma empresa.

	public void atualizarEmpresa(EmpresaVem empresa) throws EmpresaNaoEncontradaException {
		if (this.existe(empresa.getCnpj())) {
			for (int i = 0; i < this.indice; i++) {
				if (this.contas[i].getCnpj().equals(empresa.getCnpj())) {
					this.contas[i] = empresa;
				}
			}
		} else {
			throw new EmpresaNaoEncontradaException();
		}
	}

	public boolean existe(String cnpj) {
		for (int i = 0; i < this.indice; i++) {
			if (this.contas[i].getCnpj().equals(cnpj)) {
				return true;
			}
		}
		return false;

	}
}