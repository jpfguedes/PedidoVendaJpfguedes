/**
 * 
 */
package com.jpfguedes.pedidovenda.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.jpfguedes.pedidovenda.model.Pedido;
import com.jpfguedes.pedidovenda.model.StatusPedido;
import com.jpfguedes.pedidovenda.repository.Pedidos;
import com.jpfguedes.pedidovenda.util.jpa.Transactional;

/**
 * @author joao.guedes
 *
 */

public class CadastroPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public Pedido salvar(Pedido pedido) {
		if(pedido.isNovo()) {
			pedido.setDataCriacao(new Date());
			pedido.setStatus(StatusPedido.ORCAMENTO);
		}
		
		pedido.recalcularValorTotal();
		
		if(pedido.getItens().isEmpty()) {
			throw new NegocioException("O pedido deve possuir pelo menos um item.");
		}
		
		if(pedido.isValorTotalNegativo()) {
			throw new NegocioException("Valor total do pedido não pode ser negativo.");
		}
		
		pedido = this.pedidos.guardar(pedido);
		return pedido;
	}
}
