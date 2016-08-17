/**
 * 
 */
package com.jpfguedes.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.repository.Clientes;

/**
 * @author joao.guedes
 *
 */

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {
	
	@Inject
	private Clientes clientes;
	
	
	/**
	 * Ou usar este construtor ou usar o @Inject.
	 */
//	public ProdutoConverter() {
//		produtos = CDIServiceLocator.getBean(Produtos.class);
//	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;
		
		if(value != null && !value.isEmpty()) {
			retorno = this.clientes.porId(Long.parseLong(value));
		}
		
		return retorno;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Cliente cliente = (Cliente) value;
			return cliente.getId() == null ? null : cliente.getId().toString();
		}
		
		return "";
	}

}
