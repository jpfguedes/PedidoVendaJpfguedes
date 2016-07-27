/**
 * 
 */
package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.jpfguedes.pedidovenda.model.Categoria;
import com.jpfguedes.pedidovenda.model.Produto;
import com.jpfguedes.pedidovenda.repository.Categorias;
import com.jpfguedes.pedidovenda.service.CadastroProdutoService;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;

/**
 * @author joao.guedes
 *
 */

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;

	private Produto produto;
	private Categoria categoriaPai;

	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;

	public CadastroProdutoBean() {
		limpar();
	}

	public void inicializar() {
		System.out.println("Inicializando...");

		if (FacesUtil.isNotPostBack()) {
			categoriasRaizes = categorias.raizes();
		}
	}
	
	public void carregarSubcategorias() {
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}
	
	private void limpar() {
		produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();
	}

	public void salvar() {
		produto = cadastroProdutoService.salvar(produto);
		limpar();
		
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @return the categoriaPai
	 */

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	/**
	 * @param categoriaPai
	 *            the categoriaPai to set
	 */
	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	/**
	 * @return the categoriasRaizes
	 */
	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	/**
	 * @param categoriasRaizes
	 *            the categoriasRaizes to set
	 */
	public void setCategoriasRaizes(List<Categoria> categoriasRaizes) {
		this.categoriasRaizes = categoriasRaizes;
	}

	/**
	 * @return the subcategorias
	 */
	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

}
