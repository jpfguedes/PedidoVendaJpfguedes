/**
 * 
 */
package com.jpfguedes.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jpfguedes.pedidovenda.model.Grupo;

/**
 * @author joao.guedes
 *
 */

public class Grupos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Grupo guardar(Grupo grupo) {
		return manager.merge(grupo);
	}
	
	public List<Grupo> listar() {
		return manager.createQuery("from Grupo", Grupo.class).getResultList();
	}

	public Grupo porId(Long id) {
		return manager.find(Grupo.class, id);
	}
}
