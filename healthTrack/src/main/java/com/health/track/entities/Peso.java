package com.health.track.entities;

import java.util.Calendar;

public class Peso {
	
	private Long codigo;
	private Double valor;
	private Calendar data;
	
	public Peso(Long codigo, Double valor, Calendar data) {
		this.codigo = codigo;
		this.valor = valor;
		this.data = data;
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

}
