package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.repository.Clientes;
import com.jpfguedes.pedidovenda.repository.filter.ClienteFilter;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;

	private Cliente clienteSelecionado;
	private ClienteFilter filtro;
	private List<Cliente> clientesFiltrados;

	public PesquisaClientesBean() {
		filtro = new ClienteFilter();
	}
	
	public void pesquisar() {
		clientesFiltrados = clientes.filtrados(filtro);
	}
	
	public void excluir() {
		clientes.remover(clienteSelecionado);
		clientesFiltrados.remove(clienteSelecionado);
		
		FacesUtil.addInfoMessage("Cliente excluído com sucesso!");
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	/**
	 * @return the clienteSelecionado
	 */
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	/**
	 * @param clienteSelecionado
	 *            the clienteSelecionado to set
	 */
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	/**
	 * @return the filtro
	 */
	public ClienteFilter getFiltro() {
		return filtro;
	}

}