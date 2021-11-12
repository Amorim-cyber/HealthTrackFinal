package com.health.track.interfaces;

import com.health.track.entities.dao.UsuarioDAO;

public interface UsuarioInterface {
	
	public abstract UsuarioDAO getUsuario(Integer cpf,String senha);

	public abstract void setUsuario(UsuarioDAO dao);
	
	public abstract void deleteUsuario(Integer cpf,String senha);
	
}
