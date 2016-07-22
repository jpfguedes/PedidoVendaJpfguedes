package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Grupo;
import com.jpfguedes.pedidovenda.model.Usuario;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Grupo grupo;

	private List<Integer> grupos;

	public CadastroUsuarioBean() {
		grupos = new ArrayList<>();
		usuario = new Usuario();
		grupo = new Grupo();
		grupos.add(1);
	}

	public List<Integer> getGrupos() {
		return grupos;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

}