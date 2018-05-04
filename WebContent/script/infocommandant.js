$(document).ready(function(){
	$(".infcomand").click(function(){
		$("#dialoginfcom").empty();
		$("#dialoginfcom").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: ".infcomand"
			});
		$("#dialoginfcom").dialog("open");
		var idkom = $(this, ".infcomand").val();
		$.ajax({
			type: "get",
			url: "infokomendant.html",
			data: "idkomendant="+idkom,
			cach: false,
			success: function(xml){
				$(xml).find("infokomend").each(function(){
					
					var id = $(this).find("id").text();
					var firstname = $(this).find("firstname").text();
					var lastname = $(this).find("lastname").text();
					var birthday = $(this).find("birthday").text();
					var stupin = $(this).find("stupin").text();
					var stanytsya = $(this).find("stanytsya").text();
					var kurin = $(this).find("kurin").text();
					var vyshkil = $(this).find("vyshkil").text();
					var kv = $(this).find("kv").text();
					var cellnumber = $(this).find("cellnumber").text();
					var email = $(this).find("email").text();
					
					var strfilsed = "<fieldset>";
					var endfilsed = "</fieldset>";
					var namekomendant = "<p>Прізвище ім'я: <b>"+ stupin +" "+ lastname + " "+firstname+"</b></p>"; 
					var age = "<p>Дата народження: <b>"+ birthday +"</b></p>";
					if(kv == 'null') {
						kv = 'немає';
					}
					var kvst = "<p>Ступінь в КВ: <b>"+ kv + "</b></p>";
					if(kurin == 'null'){
						kurin = 'немає';
					}
					var kurinpl = "<p> Курінь: <b>" + kurin + "</b></p>";
					if(vyshkil == 'null'){
						vyshkil = 'немає';
					}
					var vyshkilk = "<p> Вишкіл: <b>" + vyshkil + "</b></p>";
					var tel = "<p> моб.тел: <b>" + cellnumber + "</b></p>";
					var mail = "<p> e-mail: <b>" + email + "</b></p>"; 
					$("#dialoginfcom").append(strfilsed + namekomendant + age+ kvst+ kurinpl+ vyshkilk+ tel + mail + endfilsed);
				});
			}
		});
		
	});
	$("#dialoginfcom").dialog({
		autoOpen: false,
		heigh: 235,
		width: 400,
		modal: true,
		buttons: {
			"ok":{
				text: "OK",
				id: "ok",
				click: function(){
					$(this).dialog("close");
				}
			}
		}
		
	});
});