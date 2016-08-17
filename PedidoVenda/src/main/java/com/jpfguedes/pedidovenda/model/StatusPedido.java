/**
 * 
 */
package com.jpfguedes.pedidovenda.model;

/**
 * @author joao.guedes
 *
 */

public enum StatusPedido {

	ORCAMENTO("Orçamento"), EMITIDO("Emitido"), CANCELADO("Cancelado");

	private String descricao;

	private StatusPedido(String descricao) {
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
