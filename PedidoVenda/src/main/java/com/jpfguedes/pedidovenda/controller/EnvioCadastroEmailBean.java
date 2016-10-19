/**
 * 
 */
package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Cliente;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;
import com.jpfguedes.pedidovenda.util.mail.Mailer;
import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;

/**
 * @author joao.guedes
 *
 */

@Named
@RequestScoped
public class EnvioCadastroEmailBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@ClienteEdicao
	private Cliente cliente;
	
	@Inject
	private Mailer mailer;
	
	public void enviarCadastro() {
		MailMessage message = mailer.novaMensagem();
		
		message.to(this.cliente.getEmail())
			.subject("Cliente #" + this.cliente.getId() + " - " + this.cliente.getNome())
			.bodyHtml(new VelocityTemplate(getClass().getResourceAsStream("/emails/cliente.template")))
			.put("cliente", this.cliente)
			.send();
		
		FacesUtil.addInfoMessage("Cadastro enviado por e-mail com sucesso!");
	}

}
