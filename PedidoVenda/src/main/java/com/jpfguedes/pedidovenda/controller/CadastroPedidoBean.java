package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.model.EnderecoEntrega;
import com.jpfguedes.pedidovenda.model.FormaPagamento;
import com.jpfguedes.pedidovenda.model.ItemPedido;
import com.jpfguedes.pedidovenda.model.Pedido;
import com.jpfguedes.pedidovenda.model.Produto;
import com.jpfguedes.pedidovenda.model.Usuario;
import com.jpfguedes.pedidovenda.repository.Clientes;
import com.jpfguedes.pedidovenda.repository.Produtos;
import com.jpfguedes.pedidovenda.repository.Usuarios;
import com.jpfguedes.pedidovenda.service.CadastroPedidoService;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;
import com.jpfguedes.pedidovenda.validation.SKU;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;

	@Inject
	private Usuarios usuarios;

	@Inject
	private Produtos produtos;

	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Produces
	@PedidoEdicao
	private Pedido pedido;
	
	private Produto produtoLinhaEditavel;
	private String sku;

	private List<Usuario> vendedores;

	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			if (this.pedido == null) {
				limpar();
			}

			this.vendedores = this.usuarios.vendedores();
			this.pedido.adicionarItemVazio();
			this.recalcularPedido();
		}
	}

	private void limpar() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
	}
	
	// Método que atualiza o pedido após o disparo do evento CDI que é um @Observes (Observa um PedidoAlteradoEvent).
	public void pedidoAlterado(@Observes PedidoAlteradoEvent event) {
		this.pedido = event.getPedido();
	}

	public void salvar() {
		this.pedido.removerItemVazio();
		
		try {
			this.pedido = this.cadastroPedidoService.salvar(this.pedido);
	
			FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
		} finally {
			this.pedido.adicionarItemVazio();
		}
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

	public void recalcularPedido() {
		if (this.pedido != null) {
			this.pedido.recalcularValorTotal();
		}
	}

	public List<Produto> completarProduto(String nome) {
		return this.produtos.porNome(nome);
	}

	public void carregarProdutoLinhaEditavel() {
		ItemPedido item = this.pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {
			if(this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil.addErrorMessage("Já existe um item no pedido com o produto informado.");
			} else {
			
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());
	
				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;
	
				this.pedido.recalcularValorTotal();
			}
		}
	}
	
	private boolean existeItemComProduto(Produto produto) {
		boolean existeItem = false;
		
		for(ItemPedido item : this.getPedido().getItens()) {
			if(produto.equals(item.getProduto())) {
				existeItem = true;
				break;
			}
		}
		
		return existeItem;
	}

	public void carregarProdutoPorSku() {
		if(StringUtils.isNotEmpty(this.sku)) {
			this.produtoLinhaEditavel = this.produtos.porSku(this.sku);
			this.carregarProdutoLinhaEditavel();
		}
	}
	
	public void atualizarQuantidade(ItemPedido item, int linha) {
		if(item.getQuantidade() < 1) {
			if(linha == 0) {
				item.setQuantidade(1);
			} else {
				this.getPedido().getItens().remove(linha);
			}
		}
		
		this.pedido.recalcularValorTotal();
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
	 * @return the produtoLinhaEditavel
	 */
	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	/**
	 * @param produtoLinhaEditavel
	 *            the produtoLinhaEditavel to set
	 */
	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	/**
	 * @return the sku
	 */
	
	@SKU
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku
	 *            the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the vendedores
	 */
	public List<Usuario> getVendedores() {
		return vendedores;
	}

}