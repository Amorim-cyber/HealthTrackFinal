package com.health.track.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.health.track.entities.Atividade;
import com.health.track.entities.dao.AtividadeDAO;

public class AtividadeMapper {
	
	public static Atividade toEntity(AtividadeDAO dao) {
		Atividade atividade = new Atividade();
			atividade.setCodigo(dao.getCodigo());
			atividade.setKcal(dao.getKcal());
			atividade.setTempo(dao.getTempo());
			atividade.setData(dao.getData());
			atividade.setDescanso(dao.getDescanso());
			atividade.setCodigoUsuario(dao.getCodigoUsuario());
			
		return atividade;
		
	}
	
	public static List<Atividade> toEntity(List<AtividadeDAO> dao){
		return dao.stream().map(x->AtividadeMapper.toEntity(x)).collect(Collectors.toList());
	}
	
	public static AtividadeDAO toDAO(Atividade atividade) {
		AtividadeDAO dao = new AtividadeDAO();
			dao.setCodigo(atividade.getCodigo());
			dao.setKcal(atividade.getKcal());
			dao.setTempo(atividade.getTempo());
			dao.setData(atividade.getData());
			dao.setDescanso(atividade.getDescanso());
			dao.setCodigoUsuario(atividade.getCodigoUsuario());
			
		return dao;
		
	}
	
	public static List<AtividadeDAO> toDAO(List<Atividade> atividade){
		return atividade.stream().map(x->AtividadeMapper.toDAO(x)).collect(Collectors.toList());
	}

}
