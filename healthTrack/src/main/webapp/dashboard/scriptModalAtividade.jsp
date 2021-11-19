<%@   page   language="java"
import="com.health.track.entities.dao.UsuarioDAO" import="com.health.track.entities.Peso" 
import="com.health.track.entities.dao.AtividadeDAO"
import="com.health.track.services.AtividadeService"
import="com.health.track.services.UsuarioService"
import="java.util.Calendar"
pageEncoding="UTF-8"%>

<%

Object usuario = request.getAttribute("usuario");

AtividadeService atividadeService = new AtividadeService();
UsuarioService usuarioService = new UsuarioService();


if(usuario==null){
	
	String[] kcal = request.getParameterValues("kcal");
	String[] tempo = request.getParameterValues("tempo");
	String[] descanso = request.getParameterValues("descanso");
	String[] codigoAtividade = request.getParameterValues("codigoAtividade");
	String[] deletar = request.getParameterValues("deletar");

	String codigoUsuario = request.getParameter("codigoUsuario");

	if(kcal.length>0) {
		
		AtividadeDAO atividadeDAO = null;
		
		for(int i = 0;i<kcal.length;i++){
			
			if(codigoAtividade[i].equals("")){
				
				atividadeDAO = new AtividadeDAO(
						Double.parseDouble(kcal[i]),
						Double.parseDouble(tempo[i]),
						Double.parseDouble(descanso[i]),
						Calendar.getInstance(),
						Long.parseLong(codigoUsuario)
						); 
				if(deletar[i].equals("s")){
					continue;
				}else{
					atividadeService.setAtividade(atividadeDAO);
				}
			}else{
				
				atividadeDAO = new AtividadeDAO(
						Long.parseLong(codigoAtividade[i]),
						Double.parseDouble(kcal[i]),
						Double.parseDouble(tempo[i]),
						Double.parseDouble(descanso[i]),
						Calendar.getInstance(),
						Long.parseLong(codigoUsuario)
						); 
				
				if(deletar[i].equals("s")){
					atividadeService.deleteAtividade(
							Long.parseLong(codigoUsuario),
							Long.parseLong(codigoAtividade[i]));
				}else{
					atividadeService.setAtividade(atividadeDAO);
				}
				
				
			}
			
			
			
		}

	}
	request.setAttribute("usuario",usuarioService.getUsuario(Long.parseLong(codigoUsuario)));
	request.getRequestDispatcher("dashboard.jsp").forward(request, response);
}

%>