function delPeso(value){
	var row = document.getElementsByClassName('table')[2].getElementsByClassName('row')[value];
	row.setAttribute("style","display: none;");
	row.getElementsByTagName('input')[2].setAttribute("value","s");

}


function delPressao(value){
	var row = document.getElementsByClassName('table')[1].getElementsByClassName('row')[value];
	row.setAttribute("style","display: none;");
	row.getElementsByTagName('input')[2].setAttribute("value","s");

}



function delAtividade(value){
	var row = document.getElementsByClassName('table')[0].getElementsByClassName('row')[value];
	row.setAttribute("style","display: none;");
	row.getElementsByTagName('input')[4].setAttribute("value","s");

}