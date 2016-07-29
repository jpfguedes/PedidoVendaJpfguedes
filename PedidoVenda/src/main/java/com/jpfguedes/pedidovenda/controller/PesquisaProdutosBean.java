package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Produto;
import com.jpfguedes.pedidovenda.repository.Produtos;
import com.jpfguedes.pedidovenda.repository.filter.ProdutoFilter;

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
	
	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();
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

}