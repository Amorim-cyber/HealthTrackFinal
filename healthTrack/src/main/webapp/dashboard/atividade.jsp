<div class="head">
	<div>
		<img src="./resources/img/fogo.png"> <span>Atividade</span>
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