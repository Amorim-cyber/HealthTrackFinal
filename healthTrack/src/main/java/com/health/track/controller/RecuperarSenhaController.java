package com.health.track.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.health.track.entities.dao.UsuarioDAO;
import com.health.track.services.UsuarioService;

/**
 * Servlet implementation class recuperarSenha
 */
@WebServlet("/recuperarSenha")
public class recuperarSenhaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsuarioService usuarioService = new UsuarioService();
	
    public recuperarSenhaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean erro = false;
		String email = request.getParameter("email");
		String mgs = "";
		UsuarioDAO usuarioDAO =  usuarioService.getUsuario(email);
		
		if(email.equals("") || usuarioDAO == null) {
			mgs = "E-mail invalido";
			request.setAttribute("mgs", mgs);
			erro =true;
		}
		
		
		if(erro) {
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}else {
			request.setAttribute("usuario", usuarioDAO);
			request.getRequestDispatcher("recuperarSenha.jsp").forward(request, response);
		}
		
		
	}

}
