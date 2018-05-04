$(document).ready(function() {
	$("#adddoc").click(function() {
		$(".notcorrect").empty();
		$("#id_dialog_doctor").dialog('option', 'position', {
			  my: "left+20 top",
			  at: "left bottom",
			  of: "#adddoc"
			});
		$("#id_dialog_doctor").dialog("open");
	});
	$("#id_dialog_doctor").dialog({
		autoOpen : false,
		heigh : 235,
		width : 320,
		modal : true,
		buttons : {
			"save" : {
				text : "Зберегти",
				id : "save",
				click : function() {
					var lastnamedoc = $("#lastnamedoc").val().trim();
					var firstnamedoc = $("#firstnamedoc").val().trim();
					var idseltypedoc = $("#seltypedoc").val().trim();
					var nameseltypedoc = $("#seltypedoc :selected").text().trim();
					var specdoc = $("#specdoc").val().trim();
					var teldoc = $("#teldoc").val().trim();
					var emaildoc = $("#emaildoc").val().trim();
					
					var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,\s]+\s*$/;
			    	var rgexp = /(^(((0[1-9]|1[0-9]|2[0-8])[-/.](0[1-9]|1[012]))|((29|30|31)[-/.](0[13578]|1[02]))|((29|30)[-/.](0[4,6,9]|11)))[-/.](19|[2-9][0-9])\d\d$)|(^29[-/.]02[-/.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/;
			    	var regexpemail = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i; 
					var regexpnumber = /^\(\d{3}\)\d{3}-\d{2}-\d{2}$/; 
					
					var i = 0;
					var txt;
					var values = $("#selectdoc>option").map(function() {
						txt = $(this).text();
							if(txt.trim().toLowerCase() == lastnamedoc.trim().toLowerCase()+" "+firstnamedoc.trim().toLowerCase()){
								i++;
							} 
					});
					if(i>0) {
						$(".notcorrect").empty();
						$(".notcorrect").append("<p id=\"notcor\">Такий лікар вже є в списку!</p>");
					} else {
						if((lastnamedoc == "" || !characterReg.test(lastnamedoc)) || 
						   (firstnamedoc == "" || !characterReg.test(firstnamedoc))|| 
						   idseltypedoc == "0" || 
						   (nameseltypedoc == "" || !characterReg.test(nameseltypedoc))|| 
						   (specdoc == "" || !characterReg.test(specdoc))|| 
						   ( teldoc == ""|| !regexpnumber.test(teldoc))|| !regexpemail.test(emaildoc) ){
							$(".notcorrect").empty();
							$(".notcorrect").append("<p id=\"notcor\">Поля повинні бути обов'язково коректно заповнені!</p>");
						} else {
							$("#selectdoc").empty();
							$.ajax({
								type: "get",
								url: "adddoctor.html",
								data: "lastnamedoc="+lastnamedoc+
									  "&firstnamedoc="+firstnamedoc+
									  "&idseltypedoc="+idseltypedoc+
									  "&nameseltypedoc="+nameseltypedoc+
									  "&specdoc="+specdoc+
									  "&teldoc="+teldoc+
									  "&emaildoc="+emaildoc,
								cach: false,
								success: function(xml){
									$(xml).find("doctor").each(function(){
										var id = $(this).find("id").text();
										var namedoctor = $(this).find("namedoctor").text();
										doctor = "<option value='"+id+"'>" + namedoctor + "</option>";
										$("#selectdoc").append(doctor);
									});
								}
							});
							$(this).dialog("close");
						}
					}
				}
			},
			"cancel" : {
				text : "Відміна",
				id : "cancel",
				click : function() {
					$(this).dialog("close");
				}
			}
		}
	});
});