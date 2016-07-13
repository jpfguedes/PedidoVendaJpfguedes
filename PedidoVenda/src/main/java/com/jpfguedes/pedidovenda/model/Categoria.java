/**
 * 
 */
package com.jpfguedes.pedidovenda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author joao.guedes
 *
 */

public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private Categoria categoriaPai;
	private List<Categoria> subcategorias = new ArrayList<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the categoriaPai
	 */
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
	 * @return the subcategorias
	 */
	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	/**
	 * @param subcategorias
	 *            the subcategorias to set
	 */
	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Categoria))
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
