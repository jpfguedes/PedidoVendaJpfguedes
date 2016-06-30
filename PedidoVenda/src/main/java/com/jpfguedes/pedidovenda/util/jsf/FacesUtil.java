/**
 * 
 */
package com.jpfguedes.pedidovenda.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author joao.guedes
 *
 */

public class FacesUtil {
	
	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
}
