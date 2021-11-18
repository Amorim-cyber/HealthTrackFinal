package com.health.track.interfaces;

import com.health.track.entities.dao.UsuarioDAO;

public interface UsuarioInterface {
	
	public abstract UsuarioDAO getUsuario(Long cpf,String senha);
	
	public abstract UsuarioDAO getUsuario(String email);

	public abstract void setUsuario(UsuarioDAO dao);
	
	public abstract void deleteUsuario(Long codigoUsuario);
	
}
