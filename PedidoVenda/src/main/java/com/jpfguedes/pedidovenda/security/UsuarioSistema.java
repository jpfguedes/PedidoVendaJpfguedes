/**
 * 
 */
package com.jpfguedes.pedidovenda.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.jpfguedes.pedidovenda.model.Usuario;

/**
 * @author joao.guedes
 * Representa um usuário do sistema para integração com
 * o Spring Security.
 */

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);

		this.usuario = usuario;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

}
