package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.model.Endereco;
import com.jpfguedes.pedidovenda.model.TipoPessoa;
import com.jpfguedes.pedidovenda.service.CadastroClienteService;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private Endereco endereco;

	private List<Endereco> enderecos;

	@Inject
	private CadastroClienteService cadastroClienteService;

	public CadastroClienteBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			if (this.cliente == null) {
				limpar();
			}
		}
	}

	public void salvar() {
		cliente = cadastroClienteService.salvar(cliente);
		limpar();

		FacesUtil.addInfoMessage("Cliente salvo com sucesso!");
	}

	public void limpar() {
		cliente = new Cliente();
		endereco = new Endereco();
		enderecos = new ArrayList<>();
	}

	public TipoPessoa[] getTiposPessoa() {
		return TipoPessoa.values();
	}

	public boolean isEditando() {
		return this.cliente.getId() != null;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @param enderecos
	 *            the enderecos to set
	 */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Endereco> getEnderecos() {
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