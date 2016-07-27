/**
 * 
 */
package com.jpfguedes.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jpfguedes.pedidovenda.model.Categoria;
import com.jpfguedes.pedidovenda.repository.Categorias;
import com.jpfguedes.pedidovenda.util.cdi.CDIServiceLocator;

/**
 * @author joao.guedes
 *
 */

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {
	
	//@Inject
	private Categorias categorias;
	
	public CategoriaConverter() {
		categorias = CDIServiceLocator.getBean(Categorias.class);
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;
		
		if(value != null && !value.isEmpty()) {
			retorno = this.categorias.porId(Long.parseLong(value));
		}
		
		return retorno;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Categoria categoria = (Categoria) value;
			return categoria.getId() == null ? null : categoria.getId().toString();
		}
		
		return "";
	}

}
