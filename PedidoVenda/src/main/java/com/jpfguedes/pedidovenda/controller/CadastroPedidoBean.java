package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.model.EnderecoEntrega;
import com.jpfguedes.pedidovenda.model.FormaPagamento;
import com.jpfguedes.pedidovenda.model.Pedido;
import com.jpfguedes.pedidovenda.model.Usuario;
import com.jpfguedes.pedidovenda.repository.Clientes;
import com.jpfguedes.pedidovenda.repository.Usuarios;
import com.jpfguedes.pedidovenda.service.CadastroPedidoService;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;

	@Inject
	private Usuarios usuarios;

	@Inject
	private CadastroPedidoService cadastroPedidoService;

	private Pedido pedido;
	private List<Usuario> vendedores;

	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			if(this.pedido == null) {
				limpar();
			}
			
			this.vendedores = this.usuarios.vendedores();
		}
	}

	private void limpar() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
	}

	public void salvar() {
		this.pedido = this.cadastroPedidoService.salvar(pedido);
		limpar();

		FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
	}

	public boolean isEditando() {
		return this.pedido.getId() != null;
	}

	public FormaPagamento[] getFormasPagamento() {
		return FormaPagamento.values();
	}

	public List<Cliente> completarCliente(String nome) {
		return clientes.porNome(nome);
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the vendedores
	 */
	public List<Usuario> getVendedores() {
		return vendedores;
	}

}