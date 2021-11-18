package com.health.track.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Atividade {

	private Long codigo;
	private Double kcal;
	private Double tempo;
	private Double descanso;
	private Calendar data;
	private Long codigoUsuario;
	
	public Atividade() {
		
	}

	public Atividade(Long codigo, Double kcal, Double tempo, Double descanso, Calendar data,
			Long codigoUsuario) {
		this.codigo = codigo;
		this.kcal = kcal;
		this.tempo = tempo;
		this.descanso = descanso;
		this.data = data;
		this.codigoUsuario = codigoUsuario;
	}



	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getKcal() {
		return kcal;
	}

	public void setKcal(Double kcal) {
		this.kcal = kcal;
	}

	public Double getTempo() {
		return tempo;
	}

	public void setTempo(Double tempo) {
		this.tempo = tempo;
	}

	public Double getDescanso() {
		return descanso;
	}

	public void setDescanso(Double descanso) {
		this.descanso = descanso;
	}

	public Calendar getData() {
		return data;
	}
	
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return sdf.format(data.getTime());
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
