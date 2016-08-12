package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Usuario;
import com.jpfguedes.pedidovenda.repository.Usuarios;
import com.jpfguedes.pedidovenda.repository.filter.UsuarioFilter;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	private Usuario usuarioSelecionado;
	private UsuarioFilter filtro;

	private List<Usuario> usuariosFiltrados;

	public PesquisaUsuariosBean() {
		filtro = new UsuarioFilter();
	}
	
	public void excluir() {
		usuarios.remover(usuarioSelecionado);
		usuariosFiltrados.remove(usuarioSelecionado);
		
		FacesUtil.addInfoMessage("Usuário " + usuarioSelecionado.getEmail() + " excluído com sucesso.");
	}
	
	public void pesquisar() {
		usuariosFiltrados = usuarios.filtrados(filtro);
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuarioSelecionado(Usuario usuario) {
		this.usuarioSelecionado = usuario;
	}

	/**
	 * @return the filtro
	 */
	public UsuarioFilter getFiltro() {
		return filtro;
	}

}