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
import com.health.track.entities.Peso;
import com.health.track.entities.dao.PesoDAO;
import com.health.track.interfaces.PesoInterface;
import com.health.track.mappers.PesoMapper;

public class PesoService implements PesoInterface{
	
	private Connection conexao;

	@Override
	public List<PesoDAO> getPeso(Long codigoPessoa) {
		List<PesoDAO> listaPeso = new ArrayList<PesoDAO>();
		PreparedStatement stmt= null;
		ResultSet rs= null;
		
		try {
			conexao= DBManager.obterConexao();
			stmt= conexao.prepareStatement("SELECT * FROM T_HIST_W WHERE "+
			"T_PERSON_CD_PERSON=? ORDER BY DT_W_REGISTER DESC");
			
			stmt.setLong(1, codigoPessoa);
			
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long idPeso = rs.getLong("CD_WEIGHT");
				Double valorPeso = rs.getDouble("NR_WEIGHT");
				Date datePeso = rs.getDate("DT_W_REGISTER");
				Long idPessoa = rs.getLong("T_PERSON_CD_PERSON");
				
				Calendar data = Calendar.getInstance();
				
				data.setTimeInMillis(datePeso.getTime());

				Peso peso = new Peso(idPeso,valorPeso,data,idPessoa);
				listaPeso.add(PesoMapper.toDAO(peso));
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
		
		return listaPeso;
	}

	@Override
	public void setPeso(PesoDAO dao) {
		PreparedStatement stmt= null;
		
		Peso peso = PesoMapper.toEntity(dao);
		
		try {
			conexao= DBManager.obterConexao();
			
			String sql;
			
			if(peso.getCodigo()==null) {
				sql = "INSERT INTO T_HIST_W (CD_WEIGHT,NR_WEIGHT,DT_W_REGISTER,T_PERSON_CD_PERSON) "
						+ "VALUES (hist_w_seq.NEXTVAL,?,?,?)";
				
				stmt= conexao.prepareStatement(sql);
				stmt.setLong(3, peso.getCodigoPessoa());
					
				Date data = new Date(peso.getData().getTimeInMillis());

				stmt.setDate(2, data);
				
				stmt.setDouble(1, peso.getValor());
			}else {
				sql = "UPDATE T_HIST_W SET NR_WEIGHT=?"+
						" WHERE CD_WEIGHT=? AND T_PERSON_CD_PERSON=?";
				
				stmt= conexao.prepareStatement(sql);
				stmt.setDouble(1, peso.getValor());
				Date data = new Date(peso.getData().getTimeInMillis());

				stmt.setDate(2, data);
				stmt.setLong(3, peso.getCodigo());
				stmt.setLong(4, peso.getCodigoPessoa());
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
	public void deletePeso(Long codigoPessoa, Long codigoPeso) {
		PreparedStatement stmt= null;
		
		try {
			conexao= DBManager.obterConexao();
			
			String sql = "DELETE FROM T_HIST_W WHERE"+
					" CD_WEIGHT=? AND T_PERSON_CD_PERSON=?";
			
			stmt= conexao.prepareStatement(sql);
			stmt.setLong(1, codigoPeso);
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
