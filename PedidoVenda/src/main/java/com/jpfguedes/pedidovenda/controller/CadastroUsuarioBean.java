package com.jpfguedes.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
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