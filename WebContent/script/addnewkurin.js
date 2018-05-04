$(document).ready(function(){
	$("#addkurin").click(function(){
		$(".notcorrect").empty();
		$("#dialog_kurin").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: "#addkurin"
			});
		$("#dialog_kurin").dialog("open");
	});
	$("#dialog_kurin").dialog({
		autoOpen: false,
		heigh: 235,
		width: 320,
		modal: true,
		buttons: {
			"save":{
				text: "Зберегти",
				id: "save",
				click: function(){
					var idkurin = $("#idkurin").val().trim();
					var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,\s]+\s*$/;
					var i = 0;
					var txt;
					var values = $("#idselkurin>option").map(function() {
						txt = $(this).text();
							if(txt.trim().toLowerCase() == idkurin.trim().toLowerCase()){
								i++;
							} 
					});
					if(i>0) {
						$(".notcorrect").empty();
						$(".notcorrect").append("<p id=\"notcor\">Такий курінь є в списку!</p>");
					} else {
						if(idkurin == "" || !characterReg.test(idkurin)){
							$(".notcorrect").empty();
							$(".notcorrect").append("<p id=\"notcor\">Поля повинні бути обов'язково заповнені!</p>");
						} else {
							$("#idselkurin").empty();
							$.ajax({
								type: "get",
								url:  "addkurin.html",
								data: "namekurin="+idkurin,
								success: function(xml){
									$(xml).find("kurin").each(function(){
										var id = $(this).find("id").text();
										var namekurin = $(this).find("namekurin").text();
										kurin = "<option value='"+id+"'>" + namekurin + "</option>";
										$("#idselkurin").append(kurin);
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