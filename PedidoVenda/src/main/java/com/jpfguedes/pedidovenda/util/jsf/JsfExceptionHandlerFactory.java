/**
 * 
 */
package com.jpfguedes.pedidovenda.util.jsf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * @author joao.guedes
 *
 */

public class JsfExceptionHandlerFactory extends ExceptionHandlerFactory {
	
	private ExceptionHandlerFactory parent;
	
	public JsfExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new JsfExceptionHandler(parent.getExceptionHandler());
	}
	
}
