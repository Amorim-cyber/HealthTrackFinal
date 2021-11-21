function insertPeso(){
	var novoValor = document.getElementById('novoPeso').value;

	if(valor == '') return;
	
	var row = document.createElement('div');
	row.setAttribute('class','row');
	
	var codPeso = document.createElement('input');
	codPeso.setAttribute('name','codigoPeso');
	codPeso.setAttribute('class','form-control');
	codPeso.setAttribute('style','display: none;');
	
	var data = document.createElement('span');
	
		    var currentdate = new Date(); 
	
		    var datetime =  currentdate.getDate() + "-"
		                    + (currentdate.getMonth()+1)  + "-" 
		                    + currentdate.getFullYear() + " "  
		                    + currentdate.getHours() + ":"  
		                    + currentdate.getMinutes() + ":" 
		                    + currentdate.getSeconds();
	
		    data.innerHTML = datetime;
		    
	var valor = document.createElement('input');
	
		    valor.innerHTML = novoValor+".0";
		    valor.setAttribute('name','valor');
		    valor.setAttribute('class','form-control');
		    valor.setAttribute('value',novoValor);
		    
	 var trash = document.createElement('i');
		    trash.setAttribute('class','bi bi-trash-fill');
	
		    var trash_button =  document.createElement('button');
		    trash_button.appendChild(trash);
		    trash_button.setAttribute("type","button");
		    trash_button.setAttribute("onclick","delPeso(this.value);");
	
		    var button_group =  document.createElement('div');
		    button_group.appendChild(trash_button);
		    
		    var del = document.createElement('input');
		    del.setAttribute('name','deletar');
		    del.setAttribute('class','form-control');
		    del.setAttribute('style','display: none;');
		    
			row.appendChild(codPeso);
			row.appendChild(data);
		    row.appendChild(valor);
		    row.appendChild(button_group);
		    row.appendChild(del);
		    row.setAttribute("style","");

			var table = document.getElementsByClassName('table')[2];
	
		    table.appendChild(row);
		    
		    var rows = table.getElementsByClassName('row');
		    
		    trash_button.setAttribute("value",rows.length-1);
		    
	var last = table.getElementsByClassName('row')[rows.length-1];
		    var span0 = last.getElementsByTagName('span')[0].innerHTML;
		    var input1 =  last.getElementsByTagName('input')[1].value;
		    
		    
	for(let i = rows.length-1; i > 0;i--){
		    	rows[i].getElementsByTagName('span')[0].innerHTML = 
		    	rows[i-1].getElementsByTagName('span')[0].innerHTML;
		    	
		    	rows[i].getElementsByTagName('input')[0].setAttribute("value",
		    	rows[i-1].getElementsByTagName('input')[0].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('input')[1].value = 
		    	rows[i-1].getElementsByTagName('input')[1].value;
		    	
		    	rows[i].getElementsByTagName('input')[2].setAttribute("value",
		    	rows[i-1].getElementsByTagName('input')[2].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("value",
		    	rows[i-1].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("onclick","delPeso(parseInt(this.value)+1);");
		    	
		    	rows[i].setAttribute("style",rows[i-1].getAttribute("style"));
		    	
		    }   
		    
			rows[0].getElementsByTagName('span')[0].innerHTML = 
		    	span0;
		    	
		    	rows[0].getElementsByTagName('input')[0].setAttribute("value","");
		    	
		    	rows[0].getElementsByTagName('input')[1].value = 
		    	input1+".0";
		    	
		    	rows[0].getElementsByTagName('input')[2].setAttribute("value","n");
		    	
		    	rows[0].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("value",0);
				
				rows[0].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("onclick","delPeso(0);");
		    	
		    	rows[0].setAttribute("style","");

			document.getElementById('novoPeso').value = '';
		    

}

function insertPressao(){
	var novoValor = document.getElementById('novoValor').value;

	if(valor == '') return;
	
	var row = document.createElement('div');
	row.setAttribute('class','row');
	
	var codPressao = document.createElement('input');
	codPressao.setAttribute('name','codigoPressao');
	codPressao.setAttribute('class','form-control');
	codPressao.setAttribute('style','display: none;');
	
	var data = document.createElement('span');
	
		    var currentdate = new Date(); 
	
		    var datetime =  currentdate.getDate() + "-"
		                    + (currentdate.getMonth()+1)  + "-" 
		                    + currentdate.getFullYear() + " "  
		                    + currentdate.getHours() + ":"  
		                    + currentdate.getMinutes() + ":" 
		                    + currentdate.getSeconds();
	
		    data.innerHTML = datetime;
		    
	var valor = document.createElement('input');
	
		    valor.innerHTML = novoValor+".0";
		    valor.setAttribute('name','valor');
		    valor.setAttribute('class','form-control');
		    valor.setAttribute('value',novoValor);
		    
	 var trash = document.createElement('i');
		    trash.setAttribute('class','bi bi-trash-fill');
	
		    var trash_button =  document.createElement('button');
		    trash_button.appendChild(trash);
		    trash_button.setAttribute("type","button");
		    trash_button.setAttribute("onclick","delPressao(this.value);");
	
		    var button_group =  document.createElement('div');
		    button_group.appendChild(trash_button);
		    
		    var del = document.createElement('input');
		    del.setAttribute('name','deletar');
		    del.setAttribute('class','form-control');
		    del.setAttribute('style','display: none;');
		    
			row.appendChild(codPressao);
			row.appendChild(data);
		    row.appendChild(valor);
		    row.appendChild(button_group);
		    row.appendChild(del);
		    row.setAttribute("style","");

			var table = document.getElementsByClassName('table')[1];
	
		    table.appendChild(row);
		    
		    var rows = table.getElementsByClassName('row');
		    
		    trash_button.setAttribute("value",rows.length-1);
		    
	var last = table.getElementsByClassName('row')[rows.length-1];
		    var span0 = last.getElementsByTagName('span')[0].innerHTML;
		    var input1 =  last.getElementsByTagName('input')[1].value;
		    
		    
	for(let i = rows.length-1; i > 0;i--){
		    	rows[i].getElementsByTagName('span')[0].innerHTML = 
		    	rows[i-1].getElementsByTagName('span')[0].innerHTML;
		    	
		    	rows[i].getElementsByTagName('input')[0].setAttribute("value",
		    	rows[i-1].getElementsByTagName('input')[0].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('input')[1].value = 
		    	rows[i-1].getElementsByTagName('input')[1].value;
		    	
		    	rows[i].getElementsByTagName('input')[2].setAttribute("value",
		    	rows[i-1].getElementsByTagName('input')[2].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("value",
		    	rows[i-1].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("onclick","delPressao(parseInt(this.value)+1);");
		    	
		    	rows[i].setAttribute("style",rows[i-1].getAttribute("style"));
		    	
		    }   
		    
			rows[0].getElementsByTagName('span')[0].innerHTML = 
		    	span0;
		    	
		    	rows[0].getElementsByTagName('input')[0].setAttribute("value","");
		    	
		    	rows[0].getElementsByTagName('input')[1].value = 
		    	input1+".0";
		    	
		    	rows[0].getElementsByTagName('input')[2].setAttribute("value","n");
		    	
		    	rows[0].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("value",0);
				
				rows[0].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("onclick","delPressao(0);");
		    	
		    	rows[0].setAttribute("style","");

			document.getElementById('novoValor').value = '';
		    

}

function insertAtividade(){
	
		    var valor_gasto = document.getElementById('novoKcal').value;
		    var valor_tempo = document.getElementById('novoTempo').value;
		    var valor_descanso = document.getElementById('novoDescanso').value;
	
		    if(valor_gasto == '' || valor_tempo == '' || valor_descanso == '') return;
	
		    var row = document.createElement('div');
	
		    row.setAttribute('class','row');
		    
		    var codAtividade = document.createElement('input');
		    codAtividade.setAttribute('name','codigoAtividade');
		    codAtividade.setAttribute('class','form-control');
		    codAtividade.setAttribute('style','display: none;');
	
		    var data = document.createElement('span');
	
		    var currentdate = new Date(); 
	
		    var datetime =  currentdate.getDate() + "-"
		                    + (currentdate.getMonth()+1)  + "-" 
		                    + currentdate.getFullYear() + " "  
		                    + currentdate.getHours() + ":"  
		                    + currentdate.getMinutes() + ":" 
		                    + currentdate.getSeconds();
	
		    data.innerHTML = datetime;
	
		    var gasto = document.createElement('input');
	
		    gasto.innerHTML = valor_gasto+".0 kcal";
		    gasto.setAttribute('name','kcal');
		    gasto.setAttribute('class','form-control');
		    gasto.setAttribute('value',valor_gasto);
	
		    var tempo = document.createElement('input');
	
		    tempo.innerHTML = valor_tempo+".0 min";
		    tempo.setAttribute('name','tempo');
		    tempo.setAttribute('class','form-control');
		    tempo.setAttribute('value',valor_tempo);
		    
	
		    var descanso = document.createElement('input');
	
		    descanso.innerHTML = valor_descanso+".0 min";
			descanso.setAttribute('name','descanso');
			descanso.setAttribute('class','form-control');
		    descanso.setAttribute('value',valor_descanso);
	
		    var trash = document.createElement('i');
		    trash.setAttribute('class','bi bi-trash-fill');
	
		    var trash_button =  document.createElement('button');
		    trash_button.appendChild(trash);
		    trash_button.setAttribute("type","button");
		    trash_button.setAttribute("onclick","delAtividade(this.value);");
	
		    var button_group =  document.createElement('div');
		    button_group.appendChild(trash_button);
		    
		    var del = document.createElement('input');
		    del.setAttribute('name','deletar');
		    del.setAttribute('class','form-control');
		    del.setAttribute('style','display: none;');
			
			row.appendChild(codAtividade);
			row.appendChild(data);
		    row.appendChild(gasto);
		    row.appendChild(tempo);
		    row.appendChild(descanso);
		    row.appendChild(button_group);
		    row.appendChild(del);
		    row.setAttribute("style","");
		    
	
		    var table = document.getElementsByClassName('table')[0];
	
		    table.appendChild(row);
		    
		    var rows = table.getElementsByClassName('row');
		    
		    trash_button.setAttribute("value",rows.length-1);
		    
		    var last = table.getElementsByClassName('row')[rows.length-1];
		    var span0 = last.getElementsByTagName('span')[0].innerHTML;
		    var input1 =  last.getElementsByTagName('input')[1].value;
		    var input2 =  last.getElementsByTagName('input')[2].value;
		    var input3 =  last.getElementsByTagName('input')[3].value;
		    
		    for(let i = rows.length-1; i > 0;i--){
		    	rows[i].getElementsByTagName('span')[0].innerHTML = 
		    	rows[i-1].getElementsByTagName('span')[0].innerHTML;
		    	
		    	rows[i].getElementsByTagName('input')[0].setAttribute("value",
		    	rows[i-1].getElementsByTagName('input')[0].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('input')[1].value = 
		    	rows[i-1].getElementsByTagName('input')[1].value;
		    	
		    	rows[i].getElementsByTagName('input')[2].value = 
		    	rows[i-1].getElementsByTagName('input')[2].value;
		    	
		    	rows[i].getElementsByTagName('input')[3].value = 
		    	rows[i-1].getElementsByTagName('input')[3].value;
		    	
		    	rows[i].getElementsByTagName('input')[4].setAttribute("value",
		    	rows[i-1].getElementsByTagName('input')[4].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("value",
		    	rows[i-1].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0].getAttribute("value"));
		    	
		    	rows[i].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("onclick","delAtividade(parseInt(this.value)+1);");
		    	
		    	rows[i].setAttribute("style",rows[i-1].getAttribute("style"));
		    	
		    }
		    
		    rows[0].getElementsByTagName('span')[0].innerHTML = 
		    	span0;
		    	
		    	rows[0].getElementsByTagName('input')[0].setAttribute("value","");
		    	
		    	rows[0].getElementsByTagName('input')[1].value = 
		    	input1+".0";
		    	
		    	rows[0].getElementsByTagName('input')[2].value = 
		    	input2+".0";
		    	
		    	rows[0].getElementsByTagName('input')[3].value = 
		    	input3+".0";
		    	
		    	rows[0].getElementsByTagName('input')[4].setAttribute("value","n");
		    	
		    	rows[0].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("value",0);
				
				rows[0].getElementsByTagName('div')[0]
		    	.getElementsByTagName('button')[0]
		    	.setAttribute("onclick","delAtividade(0);");
		    	
		    	rows[0].setAttribute("style","");

			document.getElementById('novoKcal').value = '';
			document.getElementById('novoTempo').value = '';
			document.getElementById('novoDescanso').value = '';
			
			
			
		}