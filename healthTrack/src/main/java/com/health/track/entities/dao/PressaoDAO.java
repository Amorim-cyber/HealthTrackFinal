package com.health.track.entities.dao;

import java.util.Calendar;

public class PressaoDAO {

	private Long codigo;
	private Double valor;
	private Calendar data;
	private Long codigoPessoa;
	
	public PressaoDAO() {
		
	}
	
	public PressaoDAO(Long codigo, Double valor, Calendar data, Long codigoPessoa) {
		this.codigo = codigo;
		this.valor = valor;
		this.data = data;
		this.codigoPessoa = codigoPessoa;
	}
	
	public PressaoDAO(Double valor, Calendar data, Long codigoPessoa) {
		this.valor = valor;
		this.data = data;
		this.codigoPessoa = codigoPessoa;
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

	public Long getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(Long codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	
}
