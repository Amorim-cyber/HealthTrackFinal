package com.health.track.mappers;

import com.health.track.entities.Peso;
import com.health.track.entities.dao.PesoDAO;

public class PesoMapper {
	
	public static Peso toEntity(PesoDAO dao) {
		Peso peso = new Peso();
			peso.setCodigo(dao.getCodigo());
			peso.setValor(dao.getValor());
			peso.setData(dao.getData());
			peso.setCodigoUsuario(dao.getCodigoUsuario());
		return peso;
	}

	public static PesoDAO toDAO(Peso peso) {
		PesoDAO dao = new PesoDAO();
			dao.setCodigo(peso.getCodigo());
			dao.setValor(peso.getValor());
			dao.setData(peso.getData());
			dao.setCodigoUsuario(peso.getCodigoUsuario());
		return dao;
	}
	
	
}
