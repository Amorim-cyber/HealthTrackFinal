package com.health.track.entities.dao;

import java.util.List;

import com.health.track.entities.Atividade;
import com.health.track.entities.Pessoa;

public class UsuarioDAO extends Pessoa{
	private String senha;
	private Integer metaKcal;
	private Integer metaTempo;
	private List<Atividade> listaAtividade;
	
	public UsuarioDAO() {
		
	}
	
	public UsuarioDAO(Long codigo, String senha, Integer metaKcal, Integer metaTempo, List<Atividade> listaAtividade) {
		setCodigo(codigo);
		this.senha = senha;
		this.metaKcal = metaKcal;
		this.metaTempo = metaTempo;
		this.listaAtividade = listaAtividade;
	}
	
	public UsuarioDAO(String senha, Integer metaKcal, Integer metaTempo, List<Atividade> listaAtividade) {
		this.senha = senha;
		this.metaKcal = metaKcal;
		this.metaTempo = metaTempo;
		this.listaAtividade = listaAtividade;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getMetaKcal() {
		return metaKcal;
	}
	public void setMetaKcal(Integer metaKcal) {
		this.metaKcal = metaKcal;
	}
	public Integer getMetaTempo() {
		return metaTempo;
	}
	public void setMetaTempo(Integer metaTempo) {
		this.metaTempo = metaTempo;
	}


	public List<Atividade> getListaAtividade() {
		return listaAtividade;
	}


	public void setListaAtividade(List<Atividade> listaAtividade) {
		this.listaAtividade = listaAtividade;
	}

	
}
