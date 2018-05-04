$(document).ready(function(){
	var idevent;	
	$(".report").click(function(){		
		idevent = $(this).val();
		$("#dialogreportadv").empty();
		/*$("#dialogreportadv").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: ".report"
			});		*/
		$("#dialogreportadv").dialog("open");
		var strfilsed = "<fieldset>";
		var endfilsed = "</fieldset>";
		var label = "<label> Введіть код для звітування </label>";
		var inputcode = "<input type='text' name='code' id='hashto'/>";
		$("#dialogreportadv").append(strfilsed +label + inputcode + endfilsed);	
		
		$.ajax({
			type: "get",
			url: "checkreport.html",
			data: "idevent="+idevent,
			cache: false,
			success: function(datas){
				var count = parseInt(datas);
				
				if(count>0){
					$("#report").fadeOut();
					$("#editreport").fadeIn();
				} else {
					$("#report").fadeIn();
					$("#editreport").fadeOut();
				}
			}
		
		});		
		
	});
	$("#dialogreportadv").dialog({
		autoOpen: false,
		heigh: 235,
		width: 400,
		modal: true,
		buttons: {
			"report":{
				text: "Звітувати",
				id: "report",
				click: function(){					
					$("#dialogreportadv p").empty();					
					var hashto = $("#dialogreportadv input").val();					
					$.ajax({
						type: "get",
						url:  "checkcode.html",
						data: "idevent="+idevent+
							  "&hashcode="+hashto,
						cach: false,
						success: function(html){
							if(html == 1){
								window.location = "report.html?idreport="+idevent+"&hashcode="+hashto;
								$(this).dialog("close");
							} else {
								$("#dialogreportadv").append('<p  style="color:red;"><b>Не правильний код. <br>Код був відправлений на пошту!</b></p>');
							}
						}
					});					
				}
			 },
			 "edit":{
					text: "редагувати",
					id: "editreport",
					click: function(){
						$("#dialogreportadv p").empty();					
						var hashto = $("#dialogreportadv input").val();					
						$.ajax({
							type: "get",
							url:  "checkcode.html",
							data: "idevent="+idevent+
								  "&hashcode="+hashto,
							cach: false,
							success: function(html){
								
								if(html == 1){
								//	alert(1);
									window.location = "editreport.html?idreport="+idevent+"&hashcode="+hashto;
									$(this).dialog("close");
								} else {
									$("#dialogreportadv").append('<p  style="color:red;"><b>Не правильний код. <br>Код був відправлений на пошту!</b></p>');
								}
							}
						});
					}
				},
				"view":{
					text: "перегляд",
					id: "view",
					click: function(){
						$(this).dialog("close");
					}
				},
			"cancel":{
				text: "відміна",
				id: "cancel",
				click: function(){
					$(this).dialog("close");
				}
			}
		
		}
	});
});