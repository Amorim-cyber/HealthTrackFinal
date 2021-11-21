<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${usuario.getListaPeso().size()>=3}">
<div class="head">
	<span>${String.format("%.1f",usuario.getListaPeso().get(0).getValor()-usuario.getListaPeso().get(2).getValor())}Kg
		em 3 dias</span>
		
	<a data-bs-toggle="modal" data-bs-target="#editarPeso">
		<button>
			<i class="bi bi-pencil"></i>
		</button>
	</a>
</div>
</c:if>

<c:if test="${usuario.getListaPeso().size()<3}">
<div class="head">
	<span></span>
		
	<a data-bs-toggle="modal" data-bs-target="#editarPeso">
		<button>
			<i class="bi bi-pencil"></i>
		</button>
	</a>
</div>
</c:if>
<div class="graph">
	<div class="bars">
		<div class="bar">
			<span>${usuario.getListaPeso().size()>=3?usuario.getListaPeso().get(2).getValor():''}</span>
			<div
				style="height: ${usuario.getListaPeso().size()>=3?usuario.getListaPeso().get(2).getValor()/150*100:0}%"
				id="bar1"></div>
		</div>
		<div class="bar">
			<span>${usuario.getListaPeso().size()>=2?usuario.getListaPeso().get(1).getValor():''}</span>
			<div
				style="height: ${usuario.getListaPeso().size()>=2?usuario.getListaPeso().get(1).getValor()/150*100:0}%"
				id="bar1"></div>
		</div>
		<div class="bar">
			<span>${usuario.getListaPeso().size()>=1?usuario.getListaPeso().get(0).getValor():''}</span>
			<div
				style="height: ${usuario.getListaPeso().size()>=1?usuario.getListaPeso().get(0).getValor()/150*100:0}%"
				id="bar1"></div>
		</div>
	</div>
	<div class="dates">
		<span>${usuario.getListaPeso().size()>=3?usuario.getListaPeso().get(2).getTime().substring(0,11):''}</span>
		<span>${usuario.getListaPeso().size()>=2?usuario.getListaPeso().get(1).getTime().substring(0,11):''}</span>
		<span>${usuario.getListaPeso().size()>=1?usuario.getListaPeso().get(0).getTime().substring(0,11):''}</span>
	</div>
</div>