$(document).ready(function(){
	$("#add_commandant").click(function(){
		$(".notcorrect").empty();
		$("#dialog_commandant").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: "#add_commandant"
			});
		$("#dialog_commandant").dialog("open");
	});
	$("#dialog_commandant").dialog({
		autoOpen: false,
		heigh: 235,
		width: 400,
		modal: true,
		buttons: {
			"save":{
				text: "Зберегти",
				id: "save",
				click: function(){
					var firstname = $("#idfirstname").val().trim();
					var lastname = $("#idlastname").val().trim();
					var birthday = $("#idbirthday").val().trim();
					var idselstup = $("#idselstup").val().trim();
					var namestup = $("#idselstup :selected").text().trim();
			//		var longnamestup = $("#idlongname").val();
					var idselstan = $("#idselstan").val().trim();
					var nameselstan = $("#idselstan :selected").text().trim();
					var idselkurin = $("#idselkurin").val().trim();
					var namekurin = $("#idselkurin :selected").text().trim();
					var idselvyshkil= $("#idselvyshkil").val().trim();
					var namevyshkil = $("#idselvyshkil :selected").text().trim();
					var idstupkv = $("#idstupkv").val().trim();
					var namekv = $("#idstupkv :selected").text().trim();
					var telnumb = $("#idtelnumb").val().trim();
					var email = $("#idemail").val().trim();
			    	var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,\s]+\s*$/;
			    	var rgexp = /(^(((0[1-9]|1[0-9]|2[0-8])[-/.](0[1-9]|1[012]))|((29|30|31)[-/.](0[13578]|1[02]))|((29|30)[-/.](0[4,6,9]|11)))[-/.](19|[2-9][0-9])\d\d$)|(^29[-/.]02[-/.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/;
			    	//var regexpemail = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i; 
			    	var regexpemail = /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/i;
			    	var regexpnumber = /^\(\d{3}\)\d{3}-\d{2}-\d{2}$/; 
			    	var i = 0;
					var txt;
					var values = $("#idselkomendant>option").map(function() {
						txt = $(this).text();
							if(txt.trim().toLowerCase() == lastname.trim().toLowerCase()+" "+firstname.trim().toLowerCase()){
								i++;
							} 
					});
					if(i>0) {
						$(".notcorrect").empty();
						$(".notcorrect").append("<p id=\"notcor\">Такий комендант вже є в списку!</p>");
					} else {
						if((firstname == "" || !characterReg.test(firstname)) || 
						   (lastname == "" || !characterReg.test(lastname)) || 
						   (birthday=="" || !rgexp.test(birthday)) || 
						   idselstan == "0" || 
						   (telnumb == "" || !regexpnumber.test(telnumb))|| 
						   (email == "" || !regexpemail.test(email))|| 
						   idselstup == "0"){
							$(".notcorrect").empty();
							$(".notcorrect").append("<p id=\"notcor\">Поля повинні бути обов'язково заповнені коректно!</p>");
						} else {
							$("#idselkomendant").empty();
							$.ajax({
								type: "get",
								url:  "addkomendant.html",
								data: "firstname="+firstname+
								      "&lastname="+lastname+
								      "&birthday="+birthday+
								      "&idselstup="+idselstup+
								      "&namestup="+namestup+
								 //     "&longnamestup="+longnamestup+
								      "&idselstan="+idselstan+
								      "&nameselstan="+nameselstan+
								      "&idselkurin="+idselkurin+
								      "&namekurin="+namekurin+
								      "&idselvyshkil="+idselvyshkil+
								      "&namevyshkil="+namevyshkil+
								      "&idstupkv="+idstupkv+
								      "&namekv="+namekv+
								      "&telnumb="+telnumb+
								      "&email="+email,
								cach: false,
								success: function(xml){
									$(xml).find("komendant").each(function(){
										var id = $(this).find("id").text();
										var namekomendant = $(this).find("namekomendant").text();
										komendant = "<option value='"+id+"'>" + namekomendant + "</option>";
										$("#idselkomendant").append(komendant);
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