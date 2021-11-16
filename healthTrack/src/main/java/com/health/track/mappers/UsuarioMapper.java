package com.health.track.mappers;

import com.health.track.entities.Usuario;
import com.health.track.entities.dao.UsuarioDAO;

public class UsuarioMapper {

	public static Usuario toEntity(UsuarioDAO dao) {
		
		Usuario usuario = new Usuario();
		
		if(dao.getCodigo()!=null)
			usuario.setCodigo(dao.getCodigo());
		usuario.setCodigoUsuario(dao.getCodigoUsuario());
		usuario.setAltura(dao.getAltura());
		usuario.setCpf(dao.getCpf());
		usuario.setEmail(dao.getEmail());
		usuario.setListaPeso(dao.getListaPeso());
		usuario.setListaPressao(dao.getListaPressao());
		usuario.setMetaKcal(dao.getMetaKcal());
		usuario.setMetaTempo(dao.getMetaTempo());
		usuario.setNome(dao.getNome());
		usuario.setSenha(dao.getSenha());
		usuario.setListaAtividade(dao.getListaAtividade());
		return usuario;
		
	}
	
	
	public static UsuarioDAO toDAO(Usuario usuario) {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		if(usuario.getCodigo()!=null)
			dao.setCodigo(usuario.getCodigo());
		dao.setCodigoUsuario(usuario.getCodigoUsuario());
		dao.setAltura(usuario.getAltura());
		dao.setCpf(usuario.getCpf());
		dao.setEmail(usuario.getEmail());
		dao.setListaPeso(usuario.getListaPeso());
		dao.setListaPressao(usuario.getListaPressao());
		dao.setMetaKcal(usuario.getMetaKcal());
		dao.setMetaTempo(usuario.getMetaTempo());
		dao.setNome(usuario.getNome());
		dao.setSenha(usuario.getSenha());
		dao.setListaAtividade(usuario.getListaAtividade());
		return dao;
		
	}
	
}
