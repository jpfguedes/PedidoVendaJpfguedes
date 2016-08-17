/**
 * 
 */
package com.jpfguedes.pedidovenda.repository.filter;

import java.io.Serializable;

/**
 * @author joao.guedes
 *
 */
public class ClienteFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String documentoReceitaFederal;
	private String nome;

	/**
	 * @return the documentoReceitaFederal
	 */
	public String getDocumentoReceitaFederal() {
		return documentoReceitaFederal;
	}

	/**
	 * @param documentoReceitaFederal
	 *            the documentoReceitaFederal to set
	 */
	public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
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
