/**
 * 
 */
package com.jpfguedes.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jpfguedes.pedidovenda.model.Produto;
import com.jpfguedes.pedidovenda.repository.Produtos;

/**
 * @author joao.guedes
 *
 */

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtos.porSku(produto.getSku());
		
		if(produtoExistente != null) {
			throw new NegocioException("Já existe um produto com o SKU informado.");
		}
		
		return produtos.guardar(produto);
	}
	
}
