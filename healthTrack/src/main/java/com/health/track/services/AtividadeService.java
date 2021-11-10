package com.health.track.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.health.track.dbConnection.DBManager;
import com.health.track.entities.Atividade;
import com.health.track.entities.dao.AtividadeDAO;
import com.health.track.interfaces.AtividadeInterface;
import com.health.track.mappers.AtividadeMapper;

public class AtividadeService implements AtividadeInterface{
	
	private Connection conexao;

	@Override
	public List<AtividadeDAO> getAtividade(Long codigoUsuario) {
		List<AtividadeDAO> listaAtividade = new ArrayList<AtividadeDAO>();
		PreparedStatement stmt= null;
		ResultSet rs= null;
		
		try {
			conexao= DBManager.obterConexao();
			stmt= conexao.prepareStatement("SELECT * FROM T_ACTIVITY "+
			"T_USER_CD_USER=? ORDER BY DT_A_REGISTER DESC");
			
			stmt.setLong(1, codigoUsuario);
			
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long idAtividade = rs.getLong("CD_ACTIVITY");
				Double kcal = rs.getDouble("NR_KCAL");
				Double tempo = rs.getDouble("NR_TIME");
				Double descanso = rs.getDouble("NR_REST");
				Date dateAtividade = rs.getDate("DT_A_REGISTER");
				Long idUsuario = rs.getLong("T_USER_CD_USER");
				
				Calendar data = Calendar.getInstance();
				
				data.setTimeInMillis(dateAtividade.getTime());

				Atividade atividade = new Atividade(idAtividade,kcal,tempo,descanso,data,idUsuario);
				listaAtividade.add(AtividadeMapper.toDAO(atividade));
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
		
		
		return listaAtividade;
	}

	@Override
	public void setAtividade(AtividadeDAO dao) {
		PreparedStatement stmt= null;
		
		Atividade atividade = AtividadeMapper.toEntity(dao);
		
		try {
			conexao= DBManager.obterConexao();
			
			String sql;
			
			if(atividade.getCodigo()==null) {
				sql = "INSERT INTO T_ACTIVITY (CD_ACTIVITY,NR_KCAL,NR_TIME,NR_REST,DT_A_REGISTER,T_USER_CD_USER) "
						+ "VALUES (activity_seq.NEXTVAL,?,?,?,?,?)";
				
				stmt= conexao.prepareStatement(sql);
				stmt.setLong(5, atividade.getCodigoUsuario());
					
				Date data = new Date(atividade.getData().getTimeInMillis());

				stmt.setDate(4, data);
				
				stmt.setDouble(3, atividade.getDescanso());
				stmt.setDouble(2, atividade.getTempo());
				stmt.setDouble(1, atividade.getKcal());
			}else {
				sql = "UPDATE T_ACTIVITY SET NR_KCAL=?,"+
						" NR_TIME=?,"+
						" NR_REST=?,"+
						" DT_A_REGISTER=?,"+
						" WHERE CD_ACTIVITY=? AND T_USER_CD_USER=?";
				
				stmt= conexao.prepareStatement(sql);
				stmt.setDouble(1, atividade.getKcal());
				stmt.setDouble(2, atividade.getTempo());
				stmt.setDouble(3, atividade.getDescanso());
				Date data = new Date(atividade.getData().getTimeInMillis());

				stmt.setDate(4, data);
				stmt.setLong(5, atividade.getCodigo());
				stmt.setLong(6, atividade.getCodigoUsuario());
			}
			
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

	@Override
	public void deleteAtividade(Long codigoUsuario, Long codigoAtividade) {
		PreparedStatement stmt= null;
		
		try {
			conexao= DBManager.obterConexao();
			
			String sql = "DELETE FROM T_ACTIVITY WHERE"+
					" CD_ACTIVITY=? AND T_USER_CD_USER=?";
			
			stmt= conexao.prepareStatement(sql);
			stmt.setLong(1, codigoAtividade);
			stmt.setLong(2, codigoUsuario);
			
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
