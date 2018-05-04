$(document).ready(function(){
	var idevent;
	$(".editadv").click(function(){
		idevent = $(this).val();		
		$("#dialogeditadv").empty();
		$("#dialogeditadv").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: ".editadv"
			});
		$("#dialogeditadv").dialog("open");
		var strfilsed = "<fieldset>";
		var endfilsed = "</fieldset>";
		var label = "<label> Введіть код для редагування </label>"
		var inputcode = "<input type='text' name='code' id='hashto'/>"
		var view = "<p>Для перегляду достатньо натиснути кнопку 'ПЕРЕГЛЯД'</p>" 
		$("#dialogeditadv").append(strfilsed +label + inputcode + view + endfilsed);
	});
	$("#dialogeditadv").dialog({
		autoOpen: false,
		heigh: 235,
		width: 400,
		modal: true,
		buttons: {
			"edit":{
				text: "редагувати",
				id: "edit",
				click: function(){					
					$("#dialogeditadv p").empty();
					var hashto = $("#hashto").val();
					$.ajax({
						type: "get",
						url:  "checkcode.html",
						data: "idevent="+idevent+
							  "&hashcode="+hashto,
						cach: false,
						success: function(html){
							if(html == 1){
								window.location = "editadv.html?idedit="+idevent+"&hashcode="+hashto;
								$(this).dialog("close");
							} else {
								$("#dialogeditadv").append('<p  style="color:red;"><b>Не правильний код. <br>Код був відправлений на пошту!</b></p>');
							}
						}
					});					
				}
			 },
			 "view":{
				 text: "перегляд",
				 id: "view",
				 click: function(){
					 window.location = "viewadv.html?idview="+idevent;
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