<%@   page   language="java"   contentType="text/html; charset=UTF-8"
import="com.health.track.entities.dao.UsuarioDAO" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

Object usuario = request.getAttribute("usuario");

%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://fonts.googleapis.com/css?family=Comfortaa' rel='stylesheet'>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="./resources/css/bootstrap-icons-1.5.0/bootstrap-icons.css">
<title>Dashboard</title>
</head>
	<body>
	
		<div class="container">
		
			<h1>Dados do usuario</h1>
    		<table class="table table-striped" >
    			<tr>
    			
		            <th>Código</th>
		            <th>Senha</th>
		            <th>Meta Kcal</th>
		            <th>Meta tempo</th>
		            <th>Nome</th>
		            <th>Cpf</th>
		            <th>Email</th>
		            <th>Altura</th>
		            
		        </tr>
		        <tr>
		            <td>${usuario.getCodigo()}</td>
		            <td>${usuario.getSenha()}</td>
		            <td>${usuario.getMetaKcal()}</td>
		            <td>${usuario.getMetaTempo()}</td>
		            <td>${usuario.getNome()}</td>
		            <td>${usuario.getCpf()}</td>
		            <td>${usuario.getEmail()}</td>
		            <td>${usuario.getAltura()}</td>
		        </tr>
    		</table>
    		
    		<h1>Dados de peso</h1>
    		<table class="table table-striped" >
    			<tr>
    			
		            <th>Código</th>
		            <th>Valor</th>
		            <th>Data</th>
		            
		        </tr>
		        <c:forEach var = "peso" items="${usuario.getListaPeso()}">
		        	<tr>
    			
			            <th>${peso.getCodigo()}</th>
			            <th>${peso.getValor()}</th>
			            <th>${peso.getTime()}</th>
			            
			        </tr>
		        </c:forEach>
    		</table>
    		
    		<h1>Dados de pressão</h1>
    		<table class="table table-striped" >
    			<tr>
    			
		            <th>Código</th>
		            <th>Valor</th>
		            <th>Data</th>
		            
		        </tr>
		        <c:forEach var = "pressao" items="${usuario.getListaPressao()}">
		        	<tr>
    			
			            <th>${pressao.getCodigo()}</th>
			            <th>${pressao.getValor()}</th>
			            <th>${pressao.getTime()}</th>
			            
			        </tr>
		        </c:forEach>
    		</table>
			
		</div>
	
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>