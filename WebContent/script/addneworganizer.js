$(document).ready(function(){
	$("#addorg").click(function(){
		$(".notcorrect").empty();
		$("#id_dialog_org").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: "#addorg"
			});
		$("#id_dialog_org").dialog("open");
	});
	$("#id_dialog_org").dialog({
		autoOpen: false,
		heigh: 235,
		width: 320,
		modal: true,
		buttons: {
			"save":{
				text: "Зберегти",
				id: "save",
				click: function(){
					var idorganizer = $("#idorganizer").val().trim();
					var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,\s]+\s*$/;
					var i = 0;
					var txt;
					
					var values = $("#idselorg>option").map(function() {
						txt = $(this).text();
							if(txt.trim().toLowerCase() == idorganizer.trim().toLowerCase()){
								i++;
							} 
					});
					if(i>0) {
						$(".notcorrect").empty();
						$(".notcorrect").append("<p id=\"notcor\">Такі організатори вже є в списку!</p>");
					} else {
						if(idorganizer == "" || !characterReg.test(idorganizer)){
							$(".notcorrect").empty();
							$(".notcorrect").append("<p id=\"notcor\">Поля повинні бути обов'язково заповнені!</p>");
						} else {
							$("#idselorg").empty();
							$.ajax({
								type: "get",
								url:  "addorganizer.html",
								data: "nameorganizer="+idorganizer,
								cach: false,
								success: function(xml){
									$(xml).find("organizer").each(function(){
										var id = $(this).find("id").text();
										var nameorgan = $(this).find("nameorgan").text();
										organizer = "<option value='"+id+"'>" + nameorgan + "</option>";
										$("#idselorg").append(organizer);
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