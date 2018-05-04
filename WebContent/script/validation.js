$(document).ready(function(){
	 $('#saveAdvert').click('submit', function() {
		 
	    	var input = $("#nameadvert");
	    	var nameadvert = input.val().trim();	    	
	    	var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,-\s]+\s*$/;
	    	var characterRegVen = /^\s*[а-яА-ЯїЇіІєЄ"'.,a-zA-Z0-9,-\s]+\s*$/;

	    	if(nameadvert == "" || !characterReg.test(nameadvert)){
	    		var xy = $("#nameadvert").offset().top;
	        	$("#nameadvert").removeClass("valid").addClass("invalid");
	        	$("#eradvname").removeClass("error").addClass("error_show");
	        	$(window).scrollTop(xy);
	            return false;
	        }else{
	        	$("#nameadvert").removeClass("invalid").addClass("valid");
	        	$("#eradvname").removeClass("error_show").addClass("error");
	        }
	    	
	    	
	    	var inputdatefrom =  $('#iddatefrom');
	    	var iddatefrom = inputdatefrom.val().trim();
	    	var rgexp = /(^(((0[1-9]|1[0-9]|2[0-8])[-/.](0[1-9]|1[012]))|((29|30|31)[-/.](0[13578]|1[02]))|((29|30)[-/.](0[4,6,9]|11)))[-/.](19|[2-9][0-9])\d\d$)|(^29[-/.]02[-/.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/;
	    	var isValidDate = rgexp.test(iddatefrom);
	    	if(iddatefrom == "" || !isValidDate){
	    		var xy = $('#iddatefrom').offset().top;
	    		$("#iddatefrom").removeClass("valid").addClass("invalid");
	        	$("#fromdateto").removeClass("error").addClass("error_show");
	        	$(window).scrollTop(xy);
	            return false;
	    	} else {
	    		$("#iddatefrom").removeClass("invalid").addClass("valid");
	        	$("#fromdateto").removeClass("error_show").addClass("error");
	    	}
	    	
	    	var inputdateto =  $('#iddateto');
	    	var iddateto = inputdateto.val().trim();
	    	var rgexp = /(^(((0[1-9]|1[0-9]|2[0-8])[-/.](0[1-9]|1[012]))|((29|30|31)[-/.](0[13578]|1[02]))|((29|30)[-/.](0[4,6,9]|11)))[-/.](19|[2-9][0-9])\d\d$)|(^29[-/.]02[-/.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/;
	    	var isValidDate = rgexp.test(iddateto);	    	
	    	if(iddateto == "" || !isValidDate){
	    		var xy = $('#iddateto').offset().top;
	    		$("#iddateto").removeClass("valid").addClass("invalid");
	        	$("#fromdateto").removeClass("error").addClass("error_show");
	        	$(window).scrollTop(xy);
	            return false;
	    	} else {
	    		$("#iddateto").removeClass("invalid").addClass("valid");
	        	$("#fromdateto").removeClass("error_show").addClass("error");
	    	}
	    	
		 	var from = iddatefrom;
	    	var to = iddateto;
	    	var datestart = toDate(from);
	    	var dateend = toDate(to);
		 	
		 	if(datestart>dateend){
		 		var xy = $('#iddateto').offset().top;
		 		$("#iddatefrom").removeClass("invalid").addClass("valid");
		 		$("#iddateto").removeClass("invalid").addClass("valid");
		 		$("#equaldate").removeClass("error").addClass("error_show");
		 		$(window).scrollTop(xy);
		 		return false;
		 	} else {
		 		$("#equaldate").removeClass("error_show").addClass("error");
		 	}
	    	
	 	
		 	var selecttype = $("#selecttype").val();
		 	
			   if(selecttype == 0){
				   var xy = $("#selecttype").offset().top;
				   
				$("#selecttype").removeClass("valid").addClass("invalid");
	        	$("#typsel").removeClass("error").addClass("error_show");
	        	$(window).scrollTop(xy);
	            return false;
			   } else {
				   $("#selecttype").removeClass("invalid").addClass("valid");
		        	$("#typsel").removeClass("error_show").addClass("error");
			   }
		  
			   
			   var selectlevel = $("#selectlevel").val();
			 	
			   if(selectlevel == 0){
				   var xy = $("#selectlevel").offset().top;
				   
				$("#selectlevel").removeClass("valid").addClass("invalid");
	        	$("#levelsel").removeClass("error").addClass("error_show");
	        	$(window).scrollTop(xy);
	            return false;
			   } else {
				   $("#selectlevel").removeClass("invalid").addClass("valid");
		        	$("#levelsel").removeClass("error_show").addClass("error");
			   }
		  
			   
			   var input = $("#idvenue");
		    	var idvenue = input.val().trim();
		    	
		    	if(idvenue == "" || !characterRegVen.test(idvenue)){
		    		var xy = $("#idvenue").offset().top; 
		        	$("#idvenue").removeClass("valid").addClass("invalid");
		        	$("#errvenue").removeClass("error").addClass("error_show");
		        	$(window).scrollTop(xy);
		            return false;
		        }else{
		        	$("#idvenue").removeClass("invalid").addClass("valid");
		        	$("#errvenue").removeClass("error_show").addClass("error");
		        }
			   
			   
			var idselkomendant = $("#idselkomendant").val();
				if(idselkomendant == 0){
					var xy = $("#idselkomendant").offset().top;
					$("#idselkomendant").removeClass("valid").addClass("invalid");
		        	$("#komendt").removeClass("error").addClass("error_show");
		        	$(window).scrollTop(xy);
		        	return false;
				} else {
					$("#idselkomendant").removeClass("invalid").addClass("valid");
		        	$("#komendt").removeClass("error_show").addClass("error");
				}
			
			var idselorg = $("#idselorg").val();
			
			
				if(idselorg == 0){
					var xy = $("#idselorg").offset().top;
					$("#idselorg").removeClass("valid").addClass("invalid");
		        	$("#organ").removeClass("error").addClass("error_show");
		        	$(window).scrollTop(xy);
		        	return false;
				} else {
					$("#idselorg").removeClass("invalid").addClass("valid");
		        	$("#organ").removeClass("error_show").addClass("error");
				}
			
			var idprogram = $("#idprogram").val().trim();
				if(idprogram == ""){
					var xy = $("#idprogram").offset().top;
					$("#prog").removeClass("error").addClass("error_show");
					$(window).scrollTop(xy);
					return false;
				} else {
					$("#prog").removeClass("error_show").addClass("error");
				}
				
			var idpurpose = $("#idpurpose").val().trim();
				if(idpurpose == ""){
					var xy = $("#idpurpose").offset().top;
					$("#purps").removeClass("error").addClass("error_show");
					$(window).scrollTop(xy);
					return false;
				} else {
					$("#purps").removeClass("error_show").addClass("error");
				}
			
			var idtopicality = $("#idtopicality").val().trim();
				if(idtopicality == ""){
					var xy = $("#idtopicality").offset().top;
					$("#actl").removeClass("error").addClass("error_show");
					$(window).scrollTop(xy);
					return false;
				} else {
					$("#actl").removeClass("error_show").addClass("error");
				}
			
			var idexpectresult = $("#idexpectresult").val().trim();
				if(idexpectresult == ""){
					var xy = $("#idexpectresult").offset().top;
					$("#expect").removeClass("error").addClass("error_show");
					$(window).scrollTop(xy);
					return false;
				} else {
					$("#expect").removeClass("error_show").addClass("error");
				}
				
			var selcostitem = $(".selcostitem").val();
				if(selcostitem == 0){					
					$("#estim").removeClass("error").addClass("error_show");
					return false;
				} else {
					$("#estim").removeClass("error_show").addClass("error");
				}
				
			$("#dialog_save").dialog("open");
			return false;
			
	    });
	    
	    $('#nameadvert').on('input', function() {
			var input=$(this);
			var nameadvert=input.val().trim();
			//var characterReg = /^\s*[a-zA-Z0-9,\s]+\s*$/;
			var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'a-zA-Z0-9,-\s]+\s*$/;
			if(nameadvert == "" || !characterReg.test(nameadvert)){
				input.removeClass("valid").addClass("invalid");
			}else{
				input.removeClass("invalid").addClass("valid");
			}
		});
	    
	    $('#idvenue').on('input', function() {
			var input=$(this);
			var namevenue=input.val().trim();
			//var characterReg = /^\s*[a-zA-Z0-9,\s]+\s*$/;
			var characterReg = /^\s*[а-яА-ЯїЇіІєЄ"'.,a-zA-Z0-9,-\s]+\s*$/;
			if(namevenue == "" || !characterReg.test(namevenue)){
				input.removeClass("valid").addClass("invalid");
			}else{
				input.removeClass("invalid").addClass("valid");
			}
		});
	    
	   $('#iddatefrom').on('input',function(){
		   var input=$(this);
		   var iddatefrom=input.val().trim();
		   var stringToValidate = iddatefrom;
		   var rgexp = /(^(((0[1-9]|1[0-9]|2[0-8])[-/.](0[1-9]|1[012]))|((29|30|31)[-/.](0[13578]|1[02]))|((29|30)[-/.](0[4,6,9]|11)))[-/.](19|[2-9][0-9])\d\d$)|(^29[-/.]02[-/.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/;
		   var isValidDate = rgexp.test(stringToValidate);
		   if(iddatefrom == "" || !isValidDate){
				input.removeClass("valid").addClass("invalid");
			}else{
				input.removeClass("invalid").addClass("valid");
			}
		   
	   });
	   $('#iddateto').on('input',function(){
		   var input=$(this);
		   var iddateto=input.val().trim();
		   var stringToValidate = iddateto;
		   var rgexp = /(^(((0[1-9]|1[0-9]|2[0-8])[-/.](0[1-9]|1[012]))|((29|30|31)[-/.](0[13578]|1[02]))|((29|30)[-/.](0[4,6,9]|11)))[-/.](19|[2-9][0-9])\d\d$)|(^29[-/.]02[-/.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/;
		   var isValidDate = rgexp.test(stringToValidate);
		   if(iddateto == "" || !isValidDate){
				input.removeClass("valid").addClass("invalid");
			}else{
				input.removeClass("invalid").addClass("valid");
			}
		   
	   });
	   
	   $("#dialog_save").dialog({
			autoOpen: false,
			heigh: 235,
			width: 500,
			modal: true,
			buttons: {
				"ok":{
					text: "OK",
					id: "ok",
					click: function(){
						$('#sendAdvert').submit();
						$(this).dialog("close");
						
					}
				}
			}
			
		});	
	   
	   function toDate(dateStr) {
		    var parts = dateStr.split(".");
		    return new Date(parts[2], parts[1] - 1, parts[0]);
		}
	    
});