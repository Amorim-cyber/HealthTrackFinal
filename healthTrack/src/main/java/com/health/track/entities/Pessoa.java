package com.health.track.entities;

import java.util.List;

public class Pessoa {
	
	private Long codigo;
	private Long codigoUsuario;
	private String nome;
	private Long cpf;
	private String email;
	private Double altura;
	private List<Peso> listaPeso;
	private List<Pressao> listaPressao;
	
	public Pessoa() {
		
	}
	

	public Pessoa(Long codigo, Long codigoUsuario, String nome, Long cpf, String email, Double altura,
			List<Peso> listaPeso, List<Pressao> listaPressao) {
		this.codigo = codigo;
		this.codigoUsuario = codigoUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.altura = altura;
		this.listaPeso = listaPeso;
		this.listaPressao = listaPressao;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public List<Peso> getListaPeso() {
		return listaPeso;
	}
	public void setListaPeso(List<Peso> listaPeso) {
		this.listaPeso = listaPeso;
	}
	public List<Pressao> getListaPressao() {
		return listaPressao;
	}
	public void setListaPressao(List<Pressao> listaPressao) {
		this.listaPressao = listaPressao;
	}
	
	

}
