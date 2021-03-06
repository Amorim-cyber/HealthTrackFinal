package com.health.track.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.health.track.entities.Peso;
import com.health.track.entities.dao.PesoDAO;

public class PesoMapper {
	
	public static Peso toEntity(PesoDAO dao) {
		Peso peso = new Peso();
			peso.setCodigo(dao.getCodigo());
			peso.setValor(dao.getValor());
			peso.setData(dao.getData());
			peso.setCodigoPessoa(dao.getCodigoPessoa());
		return peso;
	}
	
	public static List<Peso> toEntity(List<PesoDAO> dao){
		return dao.stream().map(x->PesoMapper.toEntity(x)).collect(Collectors.toList());
	}

	public static PesoDAO toDAO(Peso peso) {
		PesoDAO dao = new PesoDAO();
			dao.setCodigo(peso.getCodigo());
			dao.setValor(peso.getValor());
			dao.setData(peso.getData());
			dao.setCodigoPessoa(peso.getCodigoPessoa());
		return dao;
	}
	
	public static List<PesoDAO> toDAO(List<Peso> peso){
		return peso.stream().map(x->PesoMapper.toDAO(x)).collect(Collectors.toList());
	}
	
	
}
