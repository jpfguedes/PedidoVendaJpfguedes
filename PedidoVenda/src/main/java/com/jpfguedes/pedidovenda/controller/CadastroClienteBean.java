package com.jpfguedes.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CadastroClienteBean {

	private List<Integer> enderecos;
	
	public CadastroClienteBean() {
		enderecos = new ArrayList<>();
		enderecos.add(1);
	}

	public List<Integer> getEnderecos() {
		return enderecos;
	}
	
}