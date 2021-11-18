function insert(){
	
		    var valor_gasto = document.getElementById('novoKcal').value;
		    var valor_tempo = document.getElementById('novoTempo').value;
		    var valor_descanso = document.getElementById('novoDescanso').value;
	
		    if(valor_gasto == '' || valor_tempo == '' || valor_descanso == '') return;
	
		    var row = document.createElement('div');
	
		    row.setAttribute('class','row');
	
		    var data = document.createElement('span');
	
		    var currentdate = new Date(); 
	
		    var datetime =  currentdate.getDate() + "-"
		                    + (currentdate.getMonth()+1)  + "-" 
		                    + currentdate.getFullYear() + " "  
		                    + currentdate.getHours() + ":"  
		                    + currentdate.getMinutes() + ":" 
		                    + currentdate.getSeconds();
	
		    data.innerHTML = datetime;
	
		    var gasto = document.createElement('span');
	
		    gasto.innerHTML = valor_gasto+".0 kcal";
	
		    var tempo = document.createElement('span');
	
		    tempo.innerHTML = valor_tempo+".0 min";
	
		    var descanso = document.createElement('span');
	
		    descanso.innerHTML = valor_descanso+".0 min";
	
		    var pencil = document.createElement('i');
		    pencil.setAttribute('class','bi bi-pencil');
	
		    var pencil_button =  document.createElement('button');
		    pencil_button.appendChild(pencil);
	
		    var trash = document.createElement('i');
		    trash.setAttribute('class','bi bi-trash-fill');
	
		    var trash_button =  document.createElement('button');
		    trash_button.appendChild(trash);
	
		    var button_group =  document.createElement('div');
		    button_group.appendChild(pencil_button);
		    button_group.appendChild(trash_button);
	
			row.appendChild(data);
		    row.appendChild(gasto);
		    row.appendChild(tempo);
		    row.appendChild(descanso);
		    row.appendChild(button_group);
	
		    var table = document.getElementsByClassName('table')[0];
	
		    table.appendChild(row);

			document.getElementById('novoKcal').value = '';
			document.getElementById('novoTempo').value = '';
			document.getElementById('novoDescanso').value = '';
			
			document.getElementsByClassName('modal-body')[0].getElementsByTagName('button')[0].click();
			
		}