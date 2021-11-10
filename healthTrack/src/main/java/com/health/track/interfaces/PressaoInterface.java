package com.health.track.interfaces;

import java.util.List;

import com.health.track.entities.dao.PressaoDAO;

public interface PressaoInterface {
	
	public abstract List<PressaoDAO> getPressao(Long codigoCliente);
	
	public abstract void setPressao(PressaoDAO dao);
	
	public abstract void deletePressao(Long codigoCliente, Long codigoPeso);

}
