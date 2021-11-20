<%@   page   language="java"   contentType="text/html; charset=UTF-8"
import="com.health.track.entities.dao.UsuarioDAO" import="com.health.track.entities.Peso" 
import="com.health.track.entities.dao.AtividadeDAO"
import="com.health.track.services.AtividadeService"
import="com.health.track.services.UsuarioService"
import="java.util.Calendar"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	if(kcal==null){
		request.setAttribute("usuario",usuarioService.getUsuario(Long.parseLong(codigoUsuario)));
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		return;
	}
	
	try{
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
	}catch(NumberFormatException e){
		
		request.setAttribute("usuario",usuarioService.getUsuario(Long.parseLong(codigoUsuario)));
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	
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
                            <div class="head">
                                <div>
                                    <img src="./resources/img/fogo.png">
                                    <span>Atividade</span>
                                </div>
                                <a data-bs-toggle="modal" data-bs-target="#editarAtividade">
                                <button>
                                <i class="bi bi-pencil"></i>
                                </button>
                                </a>
                            </div>
                            <div class="details">
                                <div id="gasto" class="item">
                                    <span>Gasto</span>
                                    <div>
                                        ${usuario.getListaAtividade().size()==0? 0 : usuario.getListaAtividade().get(0).getKcal()}<small>kcal</small>
                                    </div>
                                </div>
                                <div id="tempo" class="item">
                                    <span>Tempo</span>
                                    <div>
                                        ${usuario.getListaAtividade().size()==0? 0 : usuario.getListaAtividade().get(0).getTempo()}<small>min</small>
                                    </div>
                                </div>
                                <div id="repouso" class="item">
                                    <span>Repouso</span>
                                    <div>
                                        ${usuario.getListaAtividade().size()==0? 0 : usuario.getListaAtividade().get(0).getDescanso()}<small>min</small>
                                    </div>
                                </div>
                            </div>
                            <div class="footer">
                                <div class="item">
                                    <div class="circle" id="meta">
                                        ${usuario.getListaAtividade().size()==0? 0 : usuario.getListaAtividade().get(0).getKcal()/usuario.getMetaKcal()*100}%
                                    </div>
                                    <span>meta diária</span>
                                </div>
                            </div>    
                        </div>
                        <div class="cinza cardio">
                            <div class="head">
                                <div>
                                    <img id="cardio" src="./resources/img/cardio.png">
                                    <span>Cardio</span>
                                </div>
                                
                                <i class="bi bi-pencil"></i>
                            </div>
                            <div class="details">
                                <div id="pressao" class="item">
                                    <span>Pressão Arterial</span>
                                    <div>
                                        ${usuario.getListaPressao().size()==0? 0 : usuario.getListaPressao().get(0).getValor()}
                                    </div>
                                </div>
                            </div>
                            <div class="footer">
                                <div class="item">
                                    <div style="${usuario.getListaPressao().size()==0? 'background-color: #C0C0C0;' : ''}" 
                                    class="circle" id="statuspressao">
                                        <i class="${usuario.getListaPressao().size()==0? 'bi bi-dash-lg' :'bi bi-hand-thumbs-up'}"></i>
                                    </div>
                                    <span>${usuario.getListaPressao().size()==0? "Neutro":"Ótimo"}</span>
                                </div>
                            </div>    
                        </div>
                    </div>
                    <div class="evolucao">
                        <label>Evolução</label>
                        <div class="card cinza evolucao">
                        	<c:if test="${usuario.getListaPeso().size()>=3}">
                        		<span>${usuario.getListaPeso().get(0).getValor()-usuario.getListaPeso().get(2).getValor()}Kg em 3 dias</span>
                        	</c:if>
                            <div class="graph">
                                <div class="bars">
                                    <div class="bar">
                                        <span>${usuario.getListaPeso().size()>=3?usuario.getListaPeso().get(2).getValor():''}</span>
                                        <div style="height: ${usuario.getListaPeso().size()>=3?usuario.getListaPeso().get(2).getValor()/150*100:0}%" id="bar1"></div>
                                    </div>
                                    <div class="bar">
                                        <span>${usuario.getListaPeso().size()>=2?usuario.getListaPeso().get(1).getValor():''}</span>
                                        <div style="height: ${usuario.getListaPeso().size()>=2?usuario.getListaPeso().get(1).getValor()/150*100:0}%" id="bar1"></div>
                                    </div>
                                    <div class="bar">
                                        <span>${usuario.getListaPeso().size()>=1?usuario.getListaPeso().get(0).getValor():''}</span>
                                        <div style="height: ${usuario.getListaPeso().size()>=1?usuario.getListaPeso().get(0).getValor()/150*100:0}%" id="bar1"></div>
                                    </div>
                                </div>
                                <div class="dates">
                                    <span>${usuario.getListaPeso().size()>=3?usuario.getListaPeso().get(2).getTime().substring(0,11):''}</span>
                                    <span>${usuario.getListaPeso().size()>=2?usuario.getListaPeso().get(1).getTime().substring(0,11):''}</span>
                                    <span>${usuario.getListaPeso().size()>=1?usuario.getListaPeso().get(0).getTime().substring(0,11):''}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvas" aria-labelledby="offcanvasLabel">
        <div class="offcanvas-header">
            <header>
                <img class="circle" src="https://icon-library.com/images/unknown-person-icon/unknown-person-icon-10.jpg">
                ${usuario.getNome()}
            </header>
          <button type="button" class="btn-close btn-close-white text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <div class="content">
                <a href="#">
                    <button>
                        <div class="icon">
                            <i class="bi bi-house-door"></i>
                        </div>
                        <span>Dashboard</span>
                    </button>
                </a>
                <a href="#">
                    <button>
                        <div class="icon">
                            <i class="bi bi-person-fill"></i>
                        </div>
                        <span>Editar cadastro</span>
                    </button>
                </a>
                <a href="#">
                    <button>
                        <div class="icon">
                            <i class="bi bi-pencil"></i>
                        </div>
                        <span>Editar pesos</span>
                    </button>
                </a>
                <a href="http://localhost:8083/healthTrack/login/login.html">
                    <button>
                        <div class="icon">
                            <i class="bi bi-door-open-fill"></i>
                        </div>
                        <span>Deslogar da conta</span>
                    </button>
                </a>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="editarAtividade" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        
        <div class="modal-dialog modal-dialog-centered modal-lg modal-dialog-scrollable">
	          
	        <div class="modal-content">
	          	<form action="dashboard.jsp" method="post">
	          	
	          		<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Editar
							Atividade</h5>
					</div>
					<div class="modal-body">
						<button style="margin-bottom: 20px;" type="button"
							data-bs-toggle="collapse" data-bs-target="#novo"
							aria-expanded="false" aria-controls="collapseExample">
							Clique aqui para adicionar nova atividade</button>
	
						<div class="collapse" id="novo" style="margin-bottom: 20px;">
	
							<div class="card card-body">
								<input id="novoKcal" style="margin-bottom: 10px;"
									class="form-control" type="number"
									placeholder="gasto (kcal) da atividade"> <input
									id="novoTempo" style="margin-bottom: 10px;" class="form-control"
									type="number" placeholder="duração (min) da atividade"> <input
									id="novoDescanso" style="margin-bottom: 10px;"
									class="form-control" type="number"
									placeholder="tempo (min) de descanso">
								<button type="button" class="btn btn-primary"
									onclick="insertAtividade();">Adicionar</button>
							</div>
	
						</div>
						<input style="display: none;" name="codigoUsuario"
							class="form-control" value="${usuario.getCodigo()}">
	
						<div class="table">
							<div class="head">
								<span>DATA</span> <span>GASTO (KCAL)</span> <span>TEMPO
									(MIN)</span> <span>REPOUSO (MIN)</span> <span>EDIÇÃO</span>
							</div>
							<c:set var="trashIndex" value="0"/>
							<c:forEach var="atividade" items="${usuario.getListaAtividade()}">
								<div class="row" style="">
									<span>${atividade.getTime()}</span> 
									<input
										style="display: none;" name="codigoAtividade"
										class="form-control" value="${atividade.getCodigo()}">
									<input name="kcal" class="form-control"
										value="${atividade.getKcal()}"> 
									
									<input name="tempo"
										class="form-control" value="${atividade.getTempo()}"> 
										
									<input
										name="descanso" class="form-control"
										value="${atividade.getDescanso()}"> 
									<input
										style="display: none;" name="deletar" class="form-control"
										value="n">
									<div>
										<button type="button" value="${trashIndex}" onclick="delAtividade(this.value);">
											<i class="bi bi-trash-fill"></i>
										</button>
									</div>
								</div>
								<c:set var="trashIndex" value="${Integer.parseInt(trashIndex)+1}"/>
							</c:forEach>
	
						</div>
					</div>
					<div class="modal-footer">
						<div class="buttons">
							<button type="submit" data-bs-dismiss="modal" aria-label="Close">Fechar
								e salvar</button>
						</div>
					</div>
	          	
	          	
	          	</form>

				
			</div>
	          
	    </div>
        	
        
    </div>
	<script src="./resources/js/insert.js"></script>
	<script src="./resources/js/delete.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
