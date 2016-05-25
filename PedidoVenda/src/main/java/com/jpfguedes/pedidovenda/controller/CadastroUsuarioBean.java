package com.jpfguedes.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CadastroUsuarioBean {

	private List<Integer> grupos;
	
	public CadastroUsuarioBean() {
		grupos = new ArrayList<>();
		grupos.add(1);
	}

	public List<Integer> getGrupos() {
		return grupos;
	}
	
}