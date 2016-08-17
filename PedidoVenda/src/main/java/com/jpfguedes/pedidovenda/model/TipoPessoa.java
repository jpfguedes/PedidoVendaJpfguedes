/**
 * 
 */
package com.jpfguedes.pedidovenda.model;

/**
 * @author joao.guedes
 *
 */

public enum TipoPessoa {

	FISICA("Física"), 
	JURIDICA("Jurídica");

	private String descricao;

	TipoPessoa(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
