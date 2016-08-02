package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Produto;
import com.jpfguedes.pedidovenda.repository.Produtos;
import com.jpfguedes.pedidovenda.repository.filter.ProdutoFilter;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;

/**
 * @author joao.guedes
 *
 */

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;

	private Produto produtoSelecionado;

	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();
	}
	
	public void excluir() {
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getSku() + " excluído com sucesso.");
	}

	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	/**
	 * @return the filtro
	 */
	public ProdutoFilter getFiltro() {
		return filtro;
	}

	/**
	 * @return the produtoSelecionado
	 */
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	/**
	 * @param produtoSelecionado
	 *            the produtoSelecionado to set
	 */
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}