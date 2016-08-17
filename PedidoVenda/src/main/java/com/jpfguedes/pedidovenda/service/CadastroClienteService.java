/**
 * 
 */
package com.jpfguedes.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.repository.Clientes;
import com.jpfguedes.pedidovenda.util.jpa.Transactional;

/**
 * @author joao.guedes
 *
 */

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clientes.porDocumentoReceitaFederal(cliente.getDocumentoReceitaFederal());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente com o CPF/CNPJ informado!");
		}
		
		return clientes.guardar(cliente);
	}

}
