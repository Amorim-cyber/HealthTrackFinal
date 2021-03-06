package com.health.track.entities;

import java.util.List;

public class Usuario extends Pessoa{
	
	private Long codigo;
	private String senha;
	private Integer metaKcal;
	private Integer metaTempo;
	private List<Atividade> listaAtividade;
	
	public Usuario() {
		
	}
	
	
	
	public Usuario(Long codigo, String senha, Integer metaKcal, Integer metaTempo, List<Atividade> listaAtividade) {
		this.codigo = codigo;
		this.senha = senha;
		this.metaKcal = metaKcal;
		this.metaTempo = metaTempo;
		this.listaAtividade = listaAtividade;
	}



	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
