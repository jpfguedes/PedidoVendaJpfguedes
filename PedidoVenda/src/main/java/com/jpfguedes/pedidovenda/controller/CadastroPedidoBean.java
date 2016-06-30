package com.jpfguedes.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CadastroPedidoBean {

	private List<Integer> itens;
	
	public CadastroPedidoBean() {
		itens = new ArrayList<>();
		itens.add(1);
	}
	
	public void salvar() {
		
	}

	public List<Integer> getItens() {
		return itens;
	}
	
}