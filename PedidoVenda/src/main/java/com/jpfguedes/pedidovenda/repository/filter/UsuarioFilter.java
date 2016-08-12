/**
 * 
 */
package com.jpfguedes.pedidovenda.repository.filter;

import java.io.Serializable;

/**
 * @author joao.guedes
 *
 */

public class UsuarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

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
		this.nome = nome == null ? null : nome.toUpperCase();
	}

}
