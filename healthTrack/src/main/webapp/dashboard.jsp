<%@   page   language="java"   contentType="text/html; charset=UTF-8"
import="com.health.track.entities.dao.UsuarioDAO" import="com.health.track.entities.Peso" 
import="com.health.track.entities.dao.AtividadeDAO"
import="com.health.track.services.AtividadeService"
import="com.health.track.services.UsuarioService"
import="com.health.track.controller.AtividadeController"
import="java.util.Calendar"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
AtividadeController atividadeController = new AtividadeController();
Object usuario = request.getAttribute("usuario");

String chamado = request.getParameter("chamado");

if(chamado!=null){
	switch(chamado){
		case "atividade":{
			atividadeController.doPost(usuario, request, response);
			break;
		}
	}
}
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://fonts.googleapis.com/css?family=Comfortaa' rel='stylesheet'>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/bootstrap-icons-1.5.0/bootstrap-icons.css">
    <link rel="stylesheet" href="./dashboard/dashboard.css">
    <link rel="stylesheet" href="./menu/menu.css">
    <title>Dashboard</title>
</head>
<body>
    <div class="main">
        <div class="nav">
            <a data-bs-toggle="offcanvas" href="#offcanvas" role="button" aria-controls="offcanvas">
                <i class="bi bi-grid-3x3-gap-fill"></i>
            </a>
            <div class="img">
                <img src="https://icon-library.com/images/unknown-person-icon/unknown-person-icon-10.jpg">
            </div>
        </div>
        <div class="dash">
            <div class="cartao">
                <label> Bem Vindo, ${usuario.getNome()}</label>
                <div class="info">
                    <div class="diario">
                        <label>Hoje</label>
                        <div class="card cinza atividade">
                           <%@ include file="./dashboard/atividade.jsp" %>
                        </div>
                        <div class="cinza cardio">
                           <%@ include file="./dashboard/cardio.jsp" %>
                        </div>
                    </div>
                    <div class="evolucao">
                        <label>Evolução</label>
                        <div class="card cinza evolucao">
                        	<%@ include file="./dashboard/peso.jsp" %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="./menu/menu.jsp" %>
    
    <%@ include file="./dashboard/modalAtividade.jsp" %>
    
	<script src="./resources/js/insert.js"></script>
	<script src="./resources/js/delete.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
