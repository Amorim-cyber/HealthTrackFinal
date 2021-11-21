package com.health.track.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.health.track.entities.dao.PesoDAO;
import com.health.track.services.PesoService;
import com.health.track.services.UsuarioService;

public class PesoController {
	
	UsuarioService usuarioService = new UsuarioService();
	PesoService pesoService = new PesoService();
	
	public void doPost(Object usuario, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(usuario==null){
			
			String[] valor = request.getParameterValues("valor");
			String[] codigoPeso = request.getParameterValues("codigoPeso");
			String[] deletar = request.getParameterValues("deletar");
			String codigoUsuario = request.getParameter("codigoUsuario");
			
			if(valor==null){
				request.setAttribute("usuario",usuarioService.getUsuario(Long.parseLong(codigoUsuario)));
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				return;
			}
			
			try{
				
				if(valor.length>0) {
					
					PesoDAO pesoDAO = null;
					
					for(int i = 0;i<valor.length;i++){
						
						if(codigoPeso[i].equals("")){
							pesoDAO = new PesoDAO(
									Double.parseDouble(valor[i]),
									Calendar.getInstance(),
									Long.parseLong(codigoUsuario)
									);
							if(deletar[i].equals("s")){
								continue;
							}else {
								pesoService.setPeso(pesoDAO);
							}
							
						}else {
							
							pesoDAO = new PesoDAO(
									Long.parseLong(codigoPeso[i]),
									Double.parseDouble(valor[i]),
									Calendar.getInstance(),
									Long.parseLong(codigoUsuario)
									);
							
							if(deletar[i].equals("s")) {
								pesoService.deletePeso(
										Long.parseLong(codigoUsuario),
										Long.parseLong(codigoPeso[i]));
							}else {
								pesoService.setPeso(pesoDAO);
							}
							
						}
						
					}
					
				}
				request.setAttribute("usuario",usuarioService.getUsuario(Long.parseLong(codigoUsuario)));
			}catch(NumberFormatException e){
				
				request.setAttribute("usuario",usuarioService.getUsuario(Long.parseLong(codigoUsuario)));
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			
			}
			
		}
	}

}
