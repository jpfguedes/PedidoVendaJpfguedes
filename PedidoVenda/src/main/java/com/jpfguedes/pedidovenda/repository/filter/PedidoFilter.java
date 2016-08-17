/**
 * 
 */
package com.jpfguedes.pedidovenda.repository.filter;

import java.io.Serializable;
import java.util.Date;

import com.jpfguedes.pedidovenda.model.StatusPedido;

/**
 * @author joao.guedes
 *
 */

public class PedidoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroDe;
	private Long numeroAte;
	private Date dataCriacaoDe;
	private Date dataCriacaoAte;
	private String nomeVendedor;
	private String nomeCliente;
	private StatusPedido[] statuses;

	/**
	 * @return the numeroDe
	 */
	public Long getNumeroDe() {
		return numeroDe;
	}

	/**
	 * @param numeroDe
	 *            the numeroDe to set
	 */
	public void setNumeroDe(Long numeroDe) {
		this.numeroDe = numeroDe;
	}

	/**
	 * @return the numeroAte
	 */
	public Long getNumeroAte() {
		return numeroAte;
	}

	/**
	 * @param numeroAte
	 *            the numeroAte to set
	 */
	public void setNumeroAte(Long numeroAte) {
		this.numeroAte = numeroAte;
	}

	/**
	 * @return the dataCriacaoDe
	 */
	public Date getDataCriacaoDe() {
		return dataCriacaoDe;
	}

	/**
	 * @param dataCriacaoDe
	 *            the dataCriacaoDe to set
	 */
	public void setDataCriacaoDe(Date dataCriacaoDe) {
		this.dataCriacaoDe = dataCriacaoDe;
	}

	/**
	 * @return the dataCriacaoAte
	 */
	public Date getDataCriacaoAte() {
		return dataCriacaoAte;
	}

	/**
	 * @param dataCriacaoAte
	 *            the dataCriacaoAte to set
	 */
	public void setDataCriacaoAte(Date dataCriacaoAte) {
		this.dataCriacaoAte = dataCriacaoAte;
	}

	/**
	 * @return the nomeVendedor
	 */
	public String getNomeVendedor() {
		return nomeVendedor;
	}

	/**
	 * @param nomeVendedor
	 *            the nomeVendedor to set
	 */
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente
	 *            the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the statuses
	 */
	public StatusPedido[] getStatuses() {
		return statuses;
	}

	/**
	 * @param statuses
	 *            the statuses to set
	 */
	public void setStatuses(StatusPedido[] statuses) {
		this.statuses = statuses;
	}

}
