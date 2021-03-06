package com.health.track.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.health.track.entities.Pressao;
import com.health.track.entities.dao.PressaoDAO;

public class PressaoMapper {
	
	public static Pressao toEntity(PressaoDAO dao) {
		Pressao pressao = new Pressao();
			pressao.setCodigo(dao.getCodigo());
			pressao.setValor(dao.getValor());
			pressao.setData(dao.getData());
			pressao.setCodigoPessoa(dao.getCodigoPessoa());
		return pressao;
	}
	
	public static List<Pressao> toEntity(List<PressaoDAO> dao){
		return dao.stream().map(x->PressaoMapper.toEntity(x)).collect(Collectors.toList());
	}

	public static PressaoDAO toDAO(Pressao pressao) {
		PressaoDAO dao = new PressaoDAO();
			dao.setCodigo(pressao.getCodigo());
			dao.setValor(pressao.getValor());
			dao.setData(pressao.getData());
			dao.setCodigoPessoa(pressao.getCodigoPessoa());
		return dao;
	}
	
	public static List<PressaoDAO> toDAO(List<Pressao> pressao){
		return pressao.stream().map(x->PressaoMapper.toDAO(x)).collect(Collectors.toList());
	}

}
