$(document).ready(function(){
	$("#idleadership").on('click', ".addnameprovid", function(){
	//$(".addnameprovid").click(function(){
		$(".notcorrect").empty();
		$("#id_dialog_provid").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: ".addnameprovid"
			});
		$("#id_dialog_provid").dialog("open");
	});
	$("#id_dialog_provid").dialog({
		autoOpen: false,
		heigh: 235,
		width: 400,
		modal: true,
		buttons: {
			"save":{
				text: "Зберегти",
				id: "save",
				click: function(){
					var nameprovid = $("#idnameprovid").val().trim();
					var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,-\s]+\s*$/;
					var i = 0;
					var txt;
					var values = $(".selectleader>option").map(function(){
						txt = $(this).text().trim();
						if(txt.trim().toLowerCase() == nameprovid.trim().toLowerCase()){
							i++;
						}
					});
					if(i>0){
						$(".notcorrect").empty();
						$(".notcorrect").append("<p id=\"notcor\">Така назва є в списку!</p>");
					} else {
						if(nameprovid == "" || !characterReg.test(nameprovid)){
							$(".notcorrect").empty();
							$(".notcorrect").append("<p id=\"notcor\">Поля повинні бути обов'язково заповнені коректно!</p>");
						} else {
							$(".selectleader").empty();
							$.ajax({
								type: "get",
								url: "addnewnameprovid.html",
								data: "nameprovid="+nameprovid,
								cach: false,
								success: function(xml){
									$(xml).find("leadername").each(function(){
										var id = $(this).find("id").text();
										var namelider = $(this).find("namelider").text();
										lider = "<option value='"+id+"'>" + namelider + "</option>";
										$(".selectleader").append(lider);
									});
								}
							});
							$(this).dialog("close");
						}
					}
					
				}
			},
			"cancel":{
				text: "Відмінити",
				id: "cancel",
				click: function(){
					$(this).dialog("close");
				}
			}
		}
	});
});
