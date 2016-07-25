/**
 * 
 */
package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Categoria;
import com.jpfguedes.pedidovenda.model.Produto;
import com.jpfguedes.pedidovenda.repository.Categorias;

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

	private Produto produto;

	private List<Categoria> categoriasRaizes;

	public CadastroProdutoBean() {
		produto = new Produto();
	}

	public void inicializar() {
		System.out.println("Inicializando...");
		categoriasRaizes = categorias.raizes();
	}

	public void salvar() {

	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
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

}
