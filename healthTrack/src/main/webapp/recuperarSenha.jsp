<%@   page   language="java"   contentType="text/html; charset=UTF-8"
import="com.health.track.entities.dao.UsuarioDAO" import="com.health.track.entities.Peso" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

Object usuario = request.getAttribute("usuario");

%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://fonts.googleapis.com/css?family=Comfortaa' rel='stylesheet'>
    <link rel="stylesheet" href="./recuperarSenha/recuperarSenha.css">
    <title>Recuperar Senha</title>
</head>
<body>
    <form class="main" action="http://localhost:8083/healthTrack/dashboard" method="post">
        <div class="top">
            <div class="circleRight">

            </div>
        </div>
        <div class="middle">

            <div class="form">
                <div class="title">
                    HEALTHTRACK
                </div>
                <div class="aviso">
                    <label> Cadastrar sua nova senha! </label>
                    <span class="senha">Agora, crie sua nova senha </span>
                    <input name="password" class="form-control" type="password" placeholder="********">
                    <span class="senha" >Confirma pra nós essa senha :) </span>
                    <input name="password2" class="form-control" type="password" placeholder="********">

                    <div class="buttons">
                        <button name="email" value="${usuario.getEmail()}" type="submit" > SALVAR </button>
                    </div>

                </div>
            </div>

        </div>
        <div class="bottom">
            <div class="circleLeft">

            </div>
        </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>