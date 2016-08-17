/**
 * 
 */
package com.jpfguedes.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.repository.filter.ClienteFilter;
import com.jpfguedes.pedidovenda.service.NegocioException;
import com.jpfguedes.pedidovenda.util.jpa.Transactional;

/**
 * @author joao.guedes
 *
 */

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cliente guardar(Cliente cliente) {
		return manager.merge(cliente);
	}
	
	@Transactional
	public void remover(Cliente cliente) {
		try {
			cliente = porId(cliente.getId());
			manager.remove(cliente);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Cliente não pode ser excluído.");
		}
	}
	
	public Cliente porId(Long id) {
		return manager.find(Cliente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> filtrados(ClienteFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cliente.class);
		
		if(StringUtils.isNotBlank(filtro.getDocumentoReceitaFederal())) {
			criteria.add(Restrictions.eq("documentoReceitaFederal", filtro.getDocumentoReceitaFederal()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}
	
	public Cliente porDocumentoReceitaFederal(String documentoReceitaFederal) {
		try {
			return manager.createQuery("from Cliente where documentoReceitaFederal = :documentoReceitaFederal", Cliente.class)
						.setParameter("documentoReceitaFederal", documentoReceitaFederal)
						.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
