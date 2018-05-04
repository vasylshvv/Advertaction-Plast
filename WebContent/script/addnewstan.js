$(document).ready(function(){
	$("#addstan").click(function(){
		$(".notcorrect").empty();
		$("#dialog_stanyt").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: "#addstan"
			});
		$("#dialog_stanyt").dialog("open");
	});
	$("#dialog_stanyt").dialog({
		autoOpen: false,
		heigh: 235,
		width: 320,
		modal: true,
		buttons:{
			"save":{
				text: "Зберегти",
				id: "save",
				click: function(){
					var stan = $("#stan").val().trim();
					var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,-\s]+\s*$/;
					var i = 0;
					var txt;
					var values = $("#idselstan>option").map(function() {
						txt = $(this).text();
							if(txt.trim().toLowerCase() == stan.trim().toLowerCase()){
								i++;
							} 
					});
					if(i>0) {
						$(".notcorrect").empty();
						$(".notcorrect").append("<p id=\"notcor\">Така станиця є в списку!</p>");
					}else{
						if(stan == "" || !characterReg.test(stan)){
							$(".notcorrect").empty();
							$(".notcorrect").append("<p id=\"notcor\">Поля повинні бути обов'язково заповнені коректно!</p>");
						} else {
							$("#idselstan").empty();
							$.ajax({
								type: "get",
								url:  "addnewstan.html",
								data: "namestan="+stan,
								cach: false,
								success: function(xml){
									$(xml).find("stanytsya").each(function(){
										var id = $(this).find("id").text();
										var namestan = $(this).find("namestan").text();
										stanytsya = "<option value='"+id+"'>" + namestan + "</option>";
										$("#idselstan").append(stanytsya);
									})
								}
							});							
								var temp=0;
								var currentValue, maxValue;
								$('#idselstan option').each(function(){
									currentValue = $("#idselstan").val();
								//	alert('currentValue = '+currentValue);
									maxValue = Math.max(temp, currentValue);
									temp=currentValue;
								});
								$("#idselstan option[value=" + maxValue + "]").attr('selected', 'true');
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