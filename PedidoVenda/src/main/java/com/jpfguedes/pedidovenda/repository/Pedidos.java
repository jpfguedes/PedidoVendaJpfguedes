/**
 * 
 */
package com.jpfguedes.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jpfguedes.pedidovenda.model.Pedido;
import com.jpfguedes.pedidovenda.repository.filter.PedidoFilter;

/**
 * @author joao.guedes
 *
 */

public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Pedido guardar(Pedido pedido) {
		return this.manager.merge(pedido);
	}
	
	public Pedido porId(Long id) {
		return manager.find(Pedido.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> filtrados(PedidoFilter filtro) {
		
		Session session = manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Pedido.class)
				// fazemos uma associação (join) com vendedor e nomeamos como c
				.createAlias("cliente", "c")
				// fazemos uma associação (join) com vendedor e nomeamos como v
				.createAlias("vendedor", "v");
		
		if(filtro.getNumeroDe() != null) {
			// id deve ser maior ou igual (ge = greater or equal) a filtro.numeroDe 
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}
		
		if(filtro.getNumeroAte() != null) {
			// id deve ser menor ou igual (le = lower or equal) a filtro.numeroDe
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}
		
		if(filtro.getDataCriacaoDe() != null) {
			criteria.add(Restrictions.ge("dataCriacao", filtro.getDataCriacaoDe()));
		}
		
		if(filtro.getDataCriacaoAte() != null) {
			criteria.add(Restrictions.le("dataCriacao", filtro.getDataCriacaoAte()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNomeCliente())) {
			// acessamos o nome do vendedor associado ao pedido pelo alias "c", criado anteriormente
			criteria.add(Restrictions.ilike("c.nome", filtro.getNomeCliente(), MatchMode.ANYWHERE));
		}
		
		if(StringUtils.isNotBlank(filtro.getNomeVendedor())) {
			// acessamos o nome do vendedor associado ao pedido pelo alias "v", criado anteriormente
			criteria.add(Restrictions.ilike("v.nome", filtro.getNomeVendedor(), MatchMode.ANYWHERE));
		}
		
		if(filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusPedido.
			criteria.add(Restrictions.in("status", filtro.getStatuses()));
		}
		
		return criteria.addOrder(Order.asc("id")).list();
		
	}

}
