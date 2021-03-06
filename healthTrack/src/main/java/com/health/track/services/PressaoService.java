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
import com.health.track.entities.Pressao;
import com.health.track.entities.dao.PressaoDAO;
import com.health.track.interfaces.PressaoInterface;
import com.health.track.mappers.PressaoMapper;

public class PressaoService implements PressaoInterface {
	
	private Connection conexao;

	@Override
	public List<PressaoDAO> getPressao(Long codigoPessoa) {
		List<PressaoDAO> listaPressao = new ArrayList<PressaoDAO>();
		PreparedStatement stmt= null;
		ResultSet rs= null;
		
		try {
			conexao= DBManager.obterConexao();
			stmt= conexao.prepareStatement("SELECT * FROM T_HIST_PR WHERE "+
			"T_PERSON_CD_PERSON=? ORDER BY DT_PR_REGISTER DESC");
			
			stmt.setLong(1, codigoPessoa);
			
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long idPressao = rs.getLong("CD_PRESSURE");
				Double valorPressao = rs.getDouble("NR_PRESSURE");
				Date datePressao = rs.getDate("DT_PR_REGISTER");
				Long idPessoa = rs.getLong("T_PERSON_CD_PERSON");
				
				Calendar data = Calendar.getInstance();
				
				data.setTimeInMillis(datePressao.getTime());

				Pressao pressao = new Pressao(idPressao,valorPressao,data,idPessoa);
				listaPressao.add(PressaoMapper.toDAO(pressao));
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
		
		return listaPressao;
	}

	@Override
	public void setPressao(PressaoDAO dao) {
		PreparedStatement stmt= null;
		
		Pressao pressao = PressaoMapper.toEntity(dao);
		
		try {
			conexao= DBManager.obterConexao();
			
			String sql;
			
			if(pressao.getCodigo()==null) {
				sql = "INSERT INTO T_HIST_PR (CD_PRESSURE,NR_PRESSURE,DT_PR_REGISTER,T_PERSON_CD_PERSON) "
						+ "VALUES (hist_pr_seq.NEXTVAL,?,?,?)";
				
				stmt= conexao.prepareStatement(sql);
				stmt.setLong(3, pressao.getCodigoPessoa());
					
				Date data = new Date(pressao.getData().getTimeInMillis());

				stmt.setDate(2, data);
				
				stmt.setDouble(1, pressao.getValor());
			}else {
				sql = "UPDATE T_HIST_PR SET NR_PRESSURE=?"+
						" WHERE CD_PRESSURE=? AND T_PERSON_CD_PERSON=?";
				
				stmt= conexao.prepareStatement(sql);
				stmt.setDouble(1, pressao.getValor());
				stmt.setLong(2, pressao.getCodigo());
				stmt.setLong(3, pressao.getCodigoPessoa());
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
	public void deletePressao(Long codigoPessoa, Long codigoPressao) {
		PreparedStatement stmt= null;
		
		try {
			conexao= DBManager.obterConexao();
			
			String sql = "DELETE FROM T_HIST_PR WHERE"+
					" CD_PRESSURE=? AND T_PERSON_CD_PERSON=?";
			
			stmt= conexao.prepareStatement(sql);
			stmt.setLong(1, codigoPressao);
			stmt.setLong(2, codigoPessoa);
			
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
