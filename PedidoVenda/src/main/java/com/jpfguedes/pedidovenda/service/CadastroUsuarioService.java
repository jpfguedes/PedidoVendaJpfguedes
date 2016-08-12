/**
 * 
 */
package com.jpfguedes.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jpfguedes.pedidovenda.model.Usuario;
import com.jpfguedes.pedidovenda.repository.Usuarios;
import com.jpfguedes.pedidovenda.util.jpa.Transactional;

/**
 * @author joao.guedes
 *
 */

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		Usuario usuarioExistente = usuarios.porEmail(usuario.getEmail());
		
		if(usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("Já existe um usuário com o email " + usuario.getEmail() + ".");
		}
		
		return usuarios.guardar(usuario);
	}

}
