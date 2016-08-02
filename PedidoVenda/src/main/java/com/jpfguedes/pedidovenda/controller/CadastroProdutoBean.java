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

	private Produto produto = new Produto();
	private Categoria categoriaPai;

	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;

	public CadastroProdutoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			if(this.produto == null) {
				limpar();
			}
			
			categoriasRaizes = categorias.raizes();
			
			if(categoriaPai != null) {
				carregarSubcategorias();
			}
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
	
	public boolean isEditando() {
		return this.produto.getId() != null;
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
	 * @param produto
	 *            the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if(produto != null) {
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
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
