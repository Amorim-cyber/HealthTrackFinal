package com.health.track.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.health.track.entities.dao.UsuarioDAO;
import com.health.track.services.UsuarioService;

@WebServlet("/dashboard")
public class dashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioService usuarioService = new UsuarioService();

    public dashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long cpf = Long.parseLong(request.getParameter("cpf"));
		String senha = request.getParameter("password");
		
		UsuarioDAO usuarioDAO =  usuarioService.getUsuario(cpf, senha);
		request.setAttribute("usuario", usuarioDAO);
		
		
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
		
	}

}
