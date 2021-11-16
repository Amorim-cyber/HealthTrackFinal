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
		boolean erro = false;
		String page = request.getHeader("referer").substring(request.getHeader("referer").lastIndexOf("/")+1);
		Long cpf = 0L;
		if(!request.getParameter("cpf").equals("")) {
			cpf = Long.parseLong(request.getParameter("cpf"));
		}
		String senha = request.getParameter("password");
		String mgs = "";
		if(page.equals("login.html")) {
			
			UsuarioDAO usuarioDAO =  usuarioService.getUsuario(cpf, senha);
			request.setAttribute("usuario", usuarioDAO);
			
			if(request.getParameter("cpf").equals("") || senha.equals("")) {
				mgs = "Campos não foram preenchidos";
				request.setAttribute("mgs", mgs);
				erro =true;
			}else if(usuarioDAO == null){
				mgs = "Usuário não existe";
				request.setAttribute("mgs", mgs);
				erro =true;
			}

			if(erro) {
				System.out.println(request.getAttribute("mgs"));
				request.getRequestDispatcher("erro.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			}
			
		}else {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha2 = request.getParameter("password2");
				
			if(nome.equals("") ||email.equals("") ||
			request.getParameter("cpf").equals("") ||
			senha.equals("") || senha2.equals("")) {
				mgs = "Campos não foram preenchidos";
				request.setAttribute("mgs", mgs);
				erro =true;
			}else if(!senha.equals(senha2)) {
				mgs = "Senha divergente da senha de confirmação";
				request.setAttribute("mgs", mgs);
				erro =true;
			}
			
			if(erro) {
				request.getRequestDispatcher("erro.jsp").forward(request, response);
				
			}else {
				
				UsuarioDAO usuarioDAO = new UsuarioDAO(senha,500,50,null);
				usuarioDAO.setCpf(cpf);
				usuarioDAO.setNome(nome);
				usuarioDAO.setEmail(email);
				
				usuarioService.setUsuario(usuarioDAO);
				request.setAttribute("usuario", usuarioDAO);
				
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				
			}
			
			
		}	
		
	}

}
