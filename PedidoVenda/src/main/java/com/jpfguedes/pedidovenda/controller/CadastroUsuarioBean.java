package com.jpfguedes.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpfguedes.pedidovenda.model.Grupo;
import com.jpfguedes.pedidovenda.model.Usuario;
import com.jpfguedes.pedidovenda.repository.Grupos;
import com.jpfguedes.pedidovenda.service.CadastroUsuarioService;
import com.jpfguedes.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Grupo grupoSelecionado;
	private Grupo grupoExcluirTable;

	@Inject
	private Grupos gruposRepository;

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	private List<Grupo> grupos;

	public CadastroUsuarioBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			if (this.usuario == null) {
				limpar();
			}

			grupos = gruposRepository.listar();
		}
	}

	public void salvar() {
		usuario = cadastroUsuarioService.salvar(usuario);
		limpar();

		FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
	}

	public void adicionarGrupo() {
		this.usuario.getGrupos().add(grupoSelecionado);
	}
	
	public void excluirGrupo() {
		this.usuario.getGrupos().remove(grupoExcluirTable);
	}

	public void limpar() {
		usuario = new Usuario();
		grupoSelecionado = new Grupo();
		grupos = new ArrayList<>();
	}

	public boolean isEditando() {
		return this.usuario.getId() != null;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @return the grupo
	 */
	public Grupo getGrupoSelecionado() {
		return grupoSelecionado;
	}

	/**
	 * @return the grupoExcluirTable
	 */
	public Grupo getGrupoExcluirTable() {
		return grupoExcluirTable;
	}

	/**
	 * @param grupoExcluirTable
	 *            the grupoExcluirTable to set
	 */
	public void setGrupoExcluirTable(Grupo grupoExcluirTable) {
		this.grupoExcluirTable = grupoExcluirTable;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupoSelecionado(Grupo grupo) {
		this.grupoSelecionado = grupo;
	}

	/**
	 * @param grupos
	 *            the grupos to set
	 */
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}