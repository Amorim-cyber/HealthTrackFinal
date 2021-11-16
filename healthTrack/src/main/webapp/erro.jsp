<%@   page   language="java"   contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

String mgs = (String) request.getAttribute("mgs");


%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://fonts.googleapis.com/css?family=Comfortaa' rel='stylesheet'>
    <link rel="stylesheet" href="./novaConta/cadastro.css">
    <title>Erro</title>
</head>
<body>
    <form class="main" action="http://localhost:8083/healthTrack/dashboard" method="post">
        <div class="top">
            <div class="circleRight">

            </div>
        </div>
        <div class="middle" >
        	<div class="form">
        		<div class="title">
               	Ops! Ocorreu um erro
            	</div>
                    <div class="login">
                        <label style="font-size:18px" > ${mgs} </label>
                    </div>
                    <div class="buttons" style="flex-direction: row; justify-content: flex-end;">
                    	<a href="http://localhost:8083/healthTrack/login/login.html">
                    		<button type="button">
                            	RETORNAR 
                        	</button>
                    	</a>
                        
                    </div>
        	</div>
            
        </div>
        <div class="bottom">
            <div class="circleLeft">

            </div>
        </div>
    </form>
    <script type="text/javascript" src="./resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="./resources/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>