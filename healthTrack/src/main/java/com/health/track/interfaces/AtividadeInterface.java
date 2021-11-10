package com.health.track.interfaces;

import java.util.List;

import com.health.track.entities.dao.AtividadeDAO;

public interface AtividadeInterface {
	
	public abstract List<AtividadeDAO> getAtividade(Long codigoUsuario);
	
	public abstract void setAtividade(AtividadeDAO dao);
	
	public abstract void deleteAtividade(Long codigoUsuario, Long codigoAtividade);

}
