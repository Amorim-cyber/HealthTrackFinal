package com.health.track.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.health.track.entities.dao.PressaoDAO;
import com.health.track.services.PressaoService;
import com.health.track.services.UsuarioService;

public class PressaoController {
	
	UsuarioService usuarioService = new UsuarioService();
	PressaoService pressaoService = new PressaoService();
	
	public void doPost(Object usuario, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(usuario==null){
			
			String[] valor = request.getParameterValues("valor");
			String[] codigoPressao = request.getParameterValues("codigoPressao");
			String[] deletar = request.getParameterValues("deletar");
			String codigoUsuario = request.getParameter("codigoUsuario");
			
			if(valor==null){
				request.setAttribute("usuario",usuarioService.getUsuario(Long.parseLong(codigoUsuario)));
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				return;
			}
			
			try{
				
				if(valor.length>0) {
					
					PressaoDAO pressaoDAO = null;
					
					for(int i = 0;i<valor.length;i++){
						
						if(codigoPressao[i].equals("")){
							pressaoDAO = new PressaoDAO(
									Double.parseDouble(valor[i]),
									Calendar.getInstance(),
									Long.parseLong(codigoUsuario)
									);
							if(deletar[i].equals("s")){
								continue;
							}else {
								pressaoService.setPressao(pressaoDAO);
							}
							
						}else {
							
							pressaoDAO = new PressaoDAO(
									Long.parseLong(codigoPressao[i]),
									Double.parseDouble(valor[i]),
									Calendar.getInstance(),
									Long.parseLong(codigoUsuario)
									);
							
							if(deletar[i].equals("s")) {
								pressaoService.deletePressao(
										Long.parseLong(codigoUsuario),
										Long.parseLong(codigoPressao[i]));
							}else {
								pressaoService.setPressao(pressaoDAO);
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
