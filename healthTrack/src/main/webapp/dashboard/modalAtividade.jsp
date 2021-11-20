<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<input style="display: none;" name="chamado"
							class="form-control" value="atividade">
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