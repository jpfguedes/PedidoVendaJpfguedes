package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.model.Endereco;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private Endereco endereco;

	private List<Integer> enderecos;

	public CadastroClienteBean() {
		enderecos = new ArrayList<>();
		cliente = new Cliente();
		endereco = new Endereco();
		enderecos.add(1);
	}

	public List<Integer> getEnderecos() {
		return enderecos;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

}