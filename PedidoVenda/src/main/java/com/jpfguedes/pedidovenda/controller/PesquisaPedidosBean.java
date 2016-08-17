package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Pedido;
import com.jpfguedes.pedidovenda.model.StatusPedido;
import com.jpfguedes.pedidovenda.repository.Pedidos;
import com.jpfguedes.pedidovenda.repository.filter.PedidoFilter;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;

	private PedidoFilter filtro;
	private List<Pedido> pedidosFiltrados;

	public PesquisaPedidosBean() {
		filtro = new PedidoFilter();
		pedidosFiltrados = new ArrayList<>();
	}

	public void pesquisar() {
		pedidosFiltrados = pedidos.filtrados(filtro);
	}
	
	public StatusPedido[] getStatuses() {
		return StatusPedido.values(); 
	}

	/**
	 * @return the filtro
	 */
	public PedidoFilter getFiltro() {
		return filtro;
	}

	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

}