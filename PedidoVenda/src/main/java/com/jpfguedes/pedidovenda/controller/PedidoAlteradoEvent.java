/**
 * 
 */
package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;

import com.jpfguedes.pedidovenda.model.Pedido;

/**
 * @author joao.guedes
 *
 */

public class PedidoAlteradoEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedido pedido;

	public PedidoAlteradoEvent(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

}
