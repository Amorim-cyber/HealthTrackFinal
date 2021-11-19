function delAtividade(value){
	console.log(value);
	var row = document.getElementsByClassName('table')[0].getElementsByClassName('row')[value];
	row.setAttribute("style","display: none;");
	row.getElementsByTagName('input')[4].setAttribute("value","s");

}