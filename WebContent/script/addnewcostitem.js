$(document).ready(function(){
	$("#tablecostitem").on('click', ".addcostitem", function(){
	//$(".addcostitem").click(function(){
		$(".notcorrect").empty();
		$("#id_dialog_costitem").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: ".addcostitem"
			});
		$("#id_dialog_costitem").dialog("open");
	});
	$("#id_dialog_costitem").dialog({
		autoOpen: false,
		heigh: 235,
		width: 320,
		modal: true,
		buttons: {
			"save":{
				text: "Зберегти",
				id: "save",
				click: function(){
					var idcositem = $("#idcositem").val().trim();
					var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,\s]+\s*$/;
					if(idcositem == "" || !characterReg.test(idcositem)){
						$(".notcorrect").empty();
						$(".notcorrect").append("<p id=\"notcor\">Поля повинні бути обов'язково заповнені!</p>");
					} else {
						$(".selcostitem").empty();
						$.ajax({
							type: "get",
							url: "addcostitem.html",
							data: "namecostitem="+idcositem,
							cach: false,
							success: function(xml){
								$(xml).find("costitem").each(function(){
									var id = $(this).find("id").text();
									var namecostitem = $(this).find("namecostitem").text();
									costitem = "<option value='"+id+"'>" + namecostitem + "</option>";
									$(".selcostitem").append(costitem);
								});
							}
						});
						$(this).dialog("close");
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