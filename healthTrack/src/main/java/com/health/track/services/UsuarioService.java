package com.health.track.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.health.track.dbConnection.DBManager;
import com.health.track.entities.Usuario;
import com.health.track.entities.dao.UsuarioDAO;
import com.health.track.interfaces.UsuarioInterface;
import com.health.track.mappers.AtividadeMapper;
import com.health.track.mappers.PesoMapper;
import com.health.track.mappers.PressaoMapper;
import com.health.track.mappers.UsuarioMapper;

public class UsuarioService implements UsuarioInterface{
	
	private Connection conexao;
	private AtividadeService as = new AtividadeService();
	private PesoService ps = new PesoService();
	private PressaoService prs = new PressaoService();

	@Override
	public UsuarioDAO getUsuario(Long cpf, String senha) {
		PreparedStatement stmt= null;
		ResultSet rs= null;
		Usuario usuario = null;
		int count = 0;
		
		try {
			conexao= DBManager.obterConexao();
			stmt= conexao.prepareStatement("SELECT U.CD_USER,"+
			"U.DS_PASSWORD,U.NR_META_K,U.NR_META_T,"+
			"P.T_USER_CD_USER,P.NM_PERSON,P.NR_CPF,"+
			"P.DS_EMAIL,P.NR_HEIGHT FROM T_USER U"+
			" INNER JOIN T_PERSON P ON"+
			" (U.CD_USER = P.T_USER_CD_USER)"+
			" WHERE P.NR_CPF = ?"+
			" AND U.DS_PASSWORD = ?");
			
			stmt.setLong(1, cpf);
			stmt.setString(2, senha);
			
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long cdUsuario = rs.getLong("CD_USER");
				String senhaUsuario = rs.getString("DS_PASSWORD");
				Integer metaKcal = rs.getInt("NR_META_K");
				Integer metaTempo = rs.getInt("NR_META_T");
				Long cdUsuarioFK = rs.getLong("T_USER_CD_USER");
				String nomePessoa = rs.getString("NM_PERSON");
				Long cpfUsuario = rs.getLong("NR_CPF");
				String email = rs.getString("DS_EMAIL");
				Double altura = rs.getDouble("NR_HEIGHT");
				
				usuario = new Usuario(cdUsuario,senhaUsuario,
				metaKcal,metaTempo,AtividadeMapper.toEntity(as.getAtividade(cdUsuario)));
				
				usuario.setCodigoUsuario(cdUsuarioFK);
				usuario.setNome(nomePessoa);
				usuario.setCpf(cpfUsuario);
				usuario.setEmail(email);
				usuario.setAltura(altura);
				usuario.setListaPeso(PesoMapper.toEntity(ps.getPeso(cdUsuarioFK)));
				usuario.setListaPressao(PressaoMapper.toEntity(prs.getPressao(cdUsuarioFK)));
				count++;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				rs.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(count==0) return null;
		
		return UsuarioMapper.toDAO(usuario);
	}
	
	@Override
	public UsuarioDAO getUsuario(String email) {
		PreparedStatement stmt= null;
		ResultSet rs= null;
		Usuario usuario = null;
		int count = 0;
		
		
		try {
			conexao= DBManager.obterConexao();
			stmt= conexao.prepareStatement("SELECT U.CD_USER,"+
			"U.DS_PASSWORD,U.NR_META_K,U.NR_META_T,"+
			"P.T_USER_CD_USER,P.NM_PERSON,P.NR_CPF,"+
			"P.DS_EMAIL,P.NR_HEIGHT FROM T_USER U"+
			" INNER JOIN T_PERSON P ON"+
			" (U.CD_USER = P.T_USER_CD_USER)"+
			" WHERE P.DS_EMAIL = ?");
			
			stmt.setString(1, email);
			
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long cdUsuario = rs.getLong("CD_USER");
				String senhaUsuario = rs.getString("DS_PASSWORD");
				Integer metaKcal = rs.getInt("NR_META_K");
				Integer metaTempo = rs.getInt("NR_META_T");
				Long cdUsuarioFK = rs.getLong("T_USER_CD_USER");
				String nomePessoa = rs.getString("NM_PERSON");
				Long cpfUsuario = rs.getLong("NR_CPF");
				String ds_email = rs.getString("DS_EMAIL");
				Double altura = rs.getDouble("NR_HEIGHT");
				
				usuario = new Usuario(cdUsuario,senhaUsuario,
				metaKcal,metaTempo,AtividadeMapper.toEntity(as.getAtividade(cdUsuario)));
				
				usuario.setCodigoUsuario(cdUsuarioFK);
				usuario.setNome(nomePessoa);
				usuario.setCpf(cpfUsuario);
				usuario.setEmail(ds_email);
				usuario.setAltura(altura);
				usuario.setListaPeso(PesoMapper.toEntity(ps.getPeso(cdUsuarioFK)));
				usuario.setListaPressao(PressaoMapper.toEntity(prs.getPressao(cdUsuarioFK)));
				count++;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				rs.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if(count==0) return null;
		
		return UsuarioMapper.toDAO(usuario);
	}

	@Override
	public UsuarioDAO getUsuario(Long codigo) {
		PreparedStatement stmt= null;
		ResultSet rs= null;
		Usuario usuario = null;
		int count = 0;
		
		
		try {
			conexao= DBManager.obterConexao();
			stmt= conexao.prepareStatement("SELECT U.CD_USER,"+
			"U.DS_PASSWORD,U.NR_META_K,U.NR_META_T,"+
			"P.T_USER_CD_USER,P.NM_PERSON,P.NR_CPF,"+
			"P.DS_EMAIL,P.NR_HEIGHT FROM T_USER U"+
			" INNER JOIN T_PERSON P ON"+
			" (U.CD_USER = P.T_USER_CD_USER)"+
			" WHERE U.CD_USER = ?");
			
			stmt.setLong(1, codigo);
			
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long cdUsuario = rs.getLong("CD_USER");
				String senhaUsuario = rs.getString("DS_PASSWORD");
				Integer metaKcal = rs.getInt("NR_META_K");
				Integer metaTempo = rs.getInt("NR_META_T");
				Long cdUsuarioFK = rs.getLong("T_USER_CD_USER");
				String nomePessoa = rs.getString("NM_PERSON");
				Long cpfUsuario = rs.getLong("NR_CPF");
				String ds_email = rs.getString("DS_EMAIL");
				Double altura = rs.getDouble("NR_HEIGHT");
				
				usuario = new Usuario(cdUsuario,senhaUsuario,
				metaKcal,metaTempo,AtividadeMapper.toEntity(as.getAtividade(cdUsuario)));
				
				usuario.setCodigoUsuario(cdUsuarioFK);
				usuario.setNome(nomePessoa);
				usuario.setCpf(cpfUsuario);
				usuario.setEmail(ds_email);
				usuario.setAltura(altura);
				usuario.setListaPeso(PesoMapper.toEntity(ps.getPeso(cdUsuarioFK)));
				usuario.setListaPressao(PressaoMapper.toEntity(prs.getPressao(cdUsuarioFK)));
				count++;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				rs.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if(count==0) return null;
		
		return UsuarioMapper.toDAO(usuario);
	}
	
	@Override
	public void setUsuario(UsuarioDAO dao) {
		PreparedStatement stmt= null;
		
		Usuario usuario = UsuarioMapper.toEntity(dao);
		
		try {
			conexao= DBManager.obterConexao();
			
			String sql;
			
			if(usuario.getCodigo()==null) {
				sql = "INSERT INTO  t_user (cd_user, ds_password, nr_meta_k,nr_meta_t) "
						+ "VALUES (user_seq.NEXTVAL,?,?,?)";
				
				stmt= conexao.prepareStatement(sql);
				stmt.setString(1, usuario.getSenha());
				stmt.setInt(2, usuario.getMetaKcal());
				stmt.setInt(3, usuario.getMetaTempo());
				
				stmt.executeUpdate();
				
				
			}else {
				sql = "UPDATE t_user SET ds_password=?,"+
						" nr_meta_k=?,"+
						" nr_meta_t=?"+
						" WHERE cd_user=?";
				
				stmt= conexao.prepareStatement(sql);
				stmt.setString(1, usuario.getSenha());
				stmt.setInt(2, usuario.getMetaKcal());
				stmt.setInt(3, usuario.getMetaTempo());
				stmt.setLong(4, usuario.getCodigo());
				stmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(usuario.getCodigo()==null) {
			try {
				conexao= DBManager.obterConexao();
				
				String sql;
				
				
					
					sql = "INSERT INTO  t_person (cd_person, t_user_cd_user, nm_person, nr_cpf, ds_email, NR_HEIGHT) "
							+ "VALUES (person_seq.NEXTVAL," +
							"(SELECT CD_USER FROM T_USER WHERE DS_PASSWORD=?),?,?,?,null)";
					
					stmt= conexao.prepareStatement(sql);
					stmt.setString(1, usuario.getSenha());
					stmt.setString(2, usuario.getNome());
					stmt.setLong(3, usuario.getCpf());
					stmt.setString(4, usuario.getEmail());
					stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					stmt.close();
					conexao.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
				
	}

	@Override
	public void deleteUsuario(Long codigo) {
		PreparedStatement stmt= null;
		
		try {
			conexao= DBManager.obterConexao();
			
			String sql = "DELETE FROM T_USER WHERE"+
					" cd_user=?";
			
			stmt= conexao.prepareStatement(sql);
			stmt.setLong(1, codigo);
			
			stmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	

	

}
