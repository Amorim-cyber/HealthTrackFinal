package com.health.track.entities;

import java.util.Calendar;

public class Pressao {
	
	private Long codigo;
	private Double valor;
	private Calendar data;
	private Long codigoUsuario;
	
	public Pressao() {
		
	}

	public Pressao(Long codigo, Double valor, Calendar data, Long codigoUsuario) {
		this.codigo = codigo;
		this.valor = valor;
		this.data = data;
		this.codigoUsuario = codigoUsuario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	

}
