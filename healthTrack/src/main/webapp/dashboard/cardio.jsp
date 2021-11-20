<div class="head">
	<div>
		<img id="cardio" src="./resources/img/cardio.png"> <span>Cardio</span>
	</div>

	<a data-bs-toggle="modal" data-bs-target="#editarPressao">
		<button>
			<i class="bi bi-pencil"></i>
		</button>
	</a>
</div>
<div class="details">
	<div id="pressao" class="item">
		<span>Pressão Arterial</span>
		<div>${usuario.getListaPressao().size()==0? 0 : usuario.getListaPressao().get(0).getValor()}
		</div>
	</div>
</div>
<div class="footer">
	<div class="item">
		<div
			style="${usuario.getListaPressao().size()==0? 'background-color: #C0C0C0;' : ''}"
			class="circle" id="statuspressao">
			<i
				class="${usuario.getListaPressao().size()==0? 'bi bi-dash-lg' :'bi bi-hand-thumbs-up'}"></i>
		</div>
		<span>${usuario.getListaPressao().size()==0? "Neutro":"Ótimo"}</span>
	</div>
</div>
