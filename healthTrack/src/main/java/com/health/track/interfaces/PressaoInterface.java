package com.health.track.interfaces;

import java.util.List;

import com.health.track.entities.dao.PressaoDAO;

public interface PressaoInterface {
	
	public abstract List<PressaoDAO> getPeso(Long codigoCliente);
	
	public abstract void setPeso(PressaoDAO dao);
	
	public abstract void deletePeso(Long codigoCliente, Long codigoPeso);

}
