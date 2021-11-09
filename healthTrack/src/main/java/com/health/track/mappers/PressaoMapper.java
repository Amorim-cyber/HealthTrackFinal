package com.health.track.mappers;

import com.health.track.entities.Pressao;
import com.health.track.entities.dao.PressaoDAO;

public class PressaoMapper {
	
	public static Pressao toEntity(PressaoDAO dao) {
		Pressao pressao = new Pressao();
			pressao.setCodigo(dao.getCodigo());
			pressao.setValor(dao.getValor());
			pressao.setData(dao.getData());
			pressao.setCodigoUsuario(dao.getCodigoUsuario());
		return pressao;
	}

	public static PressaoDAO toDAO(Pressao pressao) {
		PressaoDAO dao = new PressaoDAO();
			dao.setCodigo(pressao.getCodigo());
			dao.setValor(pressao.getValor());
			dao.setData(pressao.getData());
			dao.setCodigoUsuario(pressao.getCodigoUsuario());
		return dao;
	}

}