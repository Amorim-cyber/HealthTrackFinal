package com.health.track.interfaces;

import java.util.List;

import com.health.track.entities.dao.PesoDAO;

public interface PesoInterface {
	
	public abstract List<PesoDAO> getPeso(Long codigoPessoa);
	
	public abstract void setPeso(PesoDAO dao);
	
	public abstract void deletePeso(Long codigoPessoa, Long codigoPeso);
	
}
