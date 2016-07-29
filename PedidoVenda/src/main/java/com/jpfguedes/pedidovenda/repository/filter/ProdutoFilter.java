/**
 * 
 */
package com.jpfguedes.pedidovenda.repository.filter;

import java.io.Serializable;

import com.jpfguedes.pedidovenda.validation.SKU;

/**
 * @author joao.guedes
 *
 */

public class ProdutoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sku;
	private String nome;

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
		
		//Operador ternário para evitar @NullPointerException
		this.sku = sku == null ? null : sku.toUpperCase();
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
