$(document).ready(function(){
	$(".recommendt").click(function(){
		$("#dialoginfrecom").empty();
		$("#dialoginfrecom").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: ".recommendt"
			});
		$("#dialoginfrecom").dialog("open");
		var idevent = $(this, ".recommendt").val();
		var i = 0;
		$.ajax({
			type: "get",
			url: "inforecommendt.html",
			data: "idrec="+idevent,
			cach: false,
			success: function(xml){
				$(xml).find("inforecommend").each(function(){
					
					i++;
					var id = $(this).find("id").text();
					var dateregs = $(this).find("dateregs").text();
					var descript = $(this).find("descript").text();
					var strfilsed = "<fieldset>";
					var endfilsed = "</fieldset>";
					var allStr = "<p>"+i+" "+dateregs+" "+descript+"</p>";
					$("#dialoginfrecom").append(strfilsed  + allStr + endfilsed);
					
				});
			}
		});
	});
	$("#dialoginfrecom").dialog({
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