$(document).ready(function(){
	$(".chngstats").click(function(){
		$("#dialog_status").empty();
		$("#dialog_status").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: ".chngstats"
			});
		$("#dialog_status").dialog("open");
		//var idkom = $(this, ".chngstats").val();
		var strfilsed = "<fieldset>";
		var endfilsed = "</fieldset>";
		var optionstatus = "";
		var selectstatus = ""; 
		$.ajax({
			type: "get",
			url: "changestatusall.html",
			//data: "idkomendant="+idkom,
			cach: false,
			success: function(xml){
				$(xml).find("liststatus").each(function(){
					
					var id = $(this).find("id").text();
					var statusdesc = $(this).find("statusdesc").text();
					
					
					optionstatus = "<option value='"+id+"'>"+statusdesc+"</option>";
					select.append("<option class='ddindent' value='"+ id +"'>"+statusdesc+"</option>");
					
					$("#dialog_status").append(strfilsed + "<select>"+optionstatus+"</select>" + endfilsed);
					
				});
				
			}
		});
		
	});
	$("#dialog_status").dialog({
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