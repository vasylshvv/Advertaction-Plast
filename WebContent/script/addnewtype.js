$(document).ready(function(){
	$("#addtype").click(function(){
		$(".notcorrect").empty();
		$("#dialog_type").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: "#addtype"
			});
		$("#dialog_type").dialog("open");
		
	//	var posX = $("#addtype").offset().left - $(document).scrollLeft() + $("#addtype").outerWidth();
    //    var posY = $("#addtype").offset().top - $(document).scrollTop() + $("#addtype").outerHeight();
		//alert('x = '+posX+ '  y = '+posY);
		//$('#dialog_type').dialog( 'option', 'position', [posX, posY] );


	});
	$("#dialog_type").dialog({
		autoOpen: false,		
		heigh: 235,
		width: 320,
		modal: true,
		buttons: {
			"save":{
				text: "Зберегти",
				id: "save",
				click: function(){
					var idtype = $("#idtype").val().trim();		
					var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,\s]+\s*$/;
					var i = 0;
					var txt;
					var values = $("#selecttype>option").map(function() {
						txt = $(this).text();
							if(txt.trim().toLowerCase() == idtype.trim().toLowerCase()){
								i++;
							} 
					});
					if(i>0) {
						$(".notcorrect").empty();
						$(".notcorrect").append("<p id=\"notcor\">Такий тип вишколу вже існує!</p>");
					} else {
						if(idtype =="" || !characterReg.test(idtype)){
							$(".notcorrect").empty();
							$(".notcorrect").append("<p id=\"notcor\">Поля повинні бути обов'язково заповнені коректно!</p>");
						} else {
							
							$("#selecttype").empty();
							$.ajax({
								type: "get",
								url: "addtypeaction.html",
								data: "nametype="+idtype,
								cach: false,
								success: function(xml){
									$(xml).find("typeaction").each(function(){
										var id = $(this).find("id").text();
										var nametype = $(this).find("nametype").text();
										typeaction = "<option value='"+id+"'>" + nametype + "</option>";
										$("#selecttype").append(typeaction);
									});
								}
							});
							$(this).dialog("close");
						}
					}
				}
			},
			"cancel":{
				text: "Відміна",
				id: "cancel",
				click: function(){
					$(this).dialog("close");
				}
			}
		}
	});
});