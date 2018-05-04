<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Зголошення акції</title>
	<meta charset="UTF-8">
 	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/style_new.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="jquery-ui-1.12.1.custom/jquery-ui.css">
	
	<style type="text/css">
	/*	
		input:valid, select:valid {
		  border: 1px solid green;
		}
		*/
		input.invalid {
  		  border: 1px solid red;
		}
	.error{
			display: none;
			margin-left: 10px;
		}		
		
		.error_show{
			color: red;
			margin-left: 10px;
		}
		
	</style>
	
	<script type="text/javascript"></script>
	<script src="jquery/jquery-1.12.0.min.js"></script>
	<script src="jquery/jquery.maskedinput.js" type="text/javascript"></script>
	<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	
	<script type="text/javascript" src="script/addnewcostitem.js"></script>
	<script type="text/javascript" src="script/datefromto.js"></script>
	<script type="text/javascript" src="script/validation.js"></script>
	<script type="text/javascript" src="script/addnewnameprovid.js"></script>

	<script type="text/javascript">
		
	jQuery(function(){
	    var counter = 1;
	    jQuery('#add').click(function(event){
	        event.preventDefault();
	        counter++;
	        var selected = '<select class="selcostitem" name="costitem'+counter+'"><option value="0">Виберіть статтю витрат</option><c:forEach items="${listcost}" var="listcost"><option value="${listcost.id}"><c:out value="${listcost.namecostitem}"></c:out></option></c:forEach></select>';
	        var row = jQuery('<tr><td>'+selected+' <input type="button" value="+" class="addcostitem"></td>'+
	        				'<td><input type="number" name="sumpart'+counter+'" value="0"></td>'+
	        				'<td><input type="number" name="sumplast'+counter+'" value="0"></td>'+
	        				'<td><input type="number" name="sumbudget'+counter+'" value="0"></td>'+
	        				'<td><input type="number" name="sumsponsor'+counter+'" value="0"></td>'+
	        				'<td><input type="number" name="sumother'+counter+'" value="0"></td>'+
	        		'</tr>');
	        
	        jQuery('table.sales').append(row);
	       $(".addcostitem").on('click');    
	    });
	   $(".addcostitem").on('click');
	    
	    
	    var countstanpart = 1;
	    $("#addparticipant").click(function(event){
	    	event.preventDefault();
	    	countstanpart++;
	    	var stanlable = '<label>Станиця: </label>';
	    	var selectedstan = '<select name="stan'+countstanpart+'" class="classselstan">'+
	    	'<option value="0">Вибрати станицю</option>'+
	    	'<c:forEach items="${liststanytsya}" var="liststanytsya"><option value="${liststanytsya.id}"><c:out value="${liststanytsya.namestan}"></c:out></option></c:forEach></select>';
	    	var particip = '<label> Кількість: </label><input type="number" min=0 value="0" name="countpart'+countstanpart+'">';	    	
	    	$('#participant').append('<br>'+stanlable+selectedstan+particip);
	    });
	    
	});
	</script>
	<script type="text/javascript">
	jQuery(function($){
		   
		   $("#idtelnumb").mask("(999)999-99-99");
		   $("#teldoc").mask("(999)999-99-99");
		   
		});
	</script>    
   <script type="text/javascript">
   jQuery(function(){
   	 var counterprovid = 1;
   		$("#addprovid").click(function(event){
   			
   			event.preventDefault();
   			counterprovid++;
   			var selected = '<select class="selectleader" name="selectprovid'+counterprovid+'">'+
   			'<option value="0">Виберіть провід</option>'+
   			'<c:forEach items="${listleadership}" var="listleadership">'+
   			'<option value="${listleadership.id}"><c:out value="${listleadership.namelider}"></c:out></option>'+
   			'</c:forEach></select>';
   			var row = jQuery('<tr><td>'+selected+' <input type="button" value="+" class="addnameprovid"></td>'+
    				'<td><input type="text" name="firstname'+counterprovid+'" class="firstname"></td>'+
    				'<td><input type="text" name="lastname'+counterprovid+'" class="lastname"></td>'+
    		'</tr>');
	        jQuery('table.leader').append(row);
   		});
   		
   		var itemcost; //= $(".costiteminput").val();
		$( ".costiteminput" ).each(function() {
			itemcost = $( this ).val();
			$("#selcost"+itemcost+" option[value=" + itemcost + "]").attr('selected', 'true');
		});
		
		$("#addphoto").change(function() {
		    var files = $(this)[0].files;
		    for (var i = 0; i < files.length; i++) {
		    	var filesname = "<br>"+files[i].name;
		    
		        $("#namefiles").append(filesname);
		    }
		});
		
   	});
   </script>
   
</head>
<body>
<%@ include file = "header.jsp" %>
<!-- HEADER -->
<!-- 
	<div class="ui-widget-header ui-corner-top form_pad">
		<h1 align="center">Крайова булава УПЮ</h1>
		<h2 align="center">Зголошення акції</h2>
	</div>
 -->
<!--  <div>
 	<h1 align="center"><a href="listevents.html">Список зголошених заходів</a></h1>
 </div>
 -->
<!-- /HEADER -->
<!-- NAVIGATION -->
<!-- 
	<div class="ui-widget-content form_pad">
		<h2>Критерії на коменданта</h2>
		<ol>
			<li>Комендантом заходу Пласту може бути дійсний член Пласту - НСОУ (член Уладу Старших Пластунів, Уладу Пластунів Сеньйорів, заприсяжений та досяг 21 років) затверджений Крайовим проводом, як комендант даного заходу.</li>
			<li>Комендант несе безпосередню відповідальність за проведення заходу відповідно до затвердженої програми; безпеку життя та здоров’я учасників заходу; звітування про проведення заходу.</li>
			<li>Перед початком заходу комендант (член проводу) повинен провести інструктаж по правилах техніки безпеки учасникам заходу.</li>
			<li>Під час проведення заходу обов’язково повинен бути присутній фахівець в галузі медицини, який в разі необхідності, зможе надати першу медичну допомогу.</li>
			<li>Про проведений захід комендант зобов’язаний подати фінансовий та творчий звіти у тритижневий термін після проведення заходу.</li>
		</ol>
		<h2>Критерії для учасників</h2>
		<h2>Вимоги до вишколу</h2>
	</div>
 -->
<!-- /NAVIGATION -->
<!-- MAIN SECTION -->
<main>
	<div class="ui-widget-content form_pad">
		<form action="report.html" method="post" id="sendAdvert" enctype="multipart/form-data" accept-charset="utf-8">
		<c:forEach items="${listeventview}" var="listeventview">
			<div class ="name" >
			
				<fieldset><legend><b>Загальні відомості</b></legend>
					<p>
						<label>Назва заходу:</label>
						<input type="hidden" value="${listeventview.id}" name="idevent">
						<strong><c:out value="${listeventview.advertname}"></c:out></strong>
					</p>
									
					<fmt:formatDate value="${listeventview.datefromadvert}" pattern="dd.MM.yyyy" var="datefrom" />
					<fmt:formatDate value="${listeventview.datetoadvert}" pattern="dd.MM.yyyy" var="dateto" />
					<p>
						<label>Дата проведення: </label>
						<label>з</label>
						<strong><c:out value="${datefrom}"></c:out></strong>
						<label>по </label>
						<strong><c:out value="${dateto}"></c:out></strong>
					</p>
									
					<p>
						<label>Вид заходу: </label>
						<strong><c:out value="${listeventview.nametypeaction}"></c:out></strong>
					</p>
					
					<p>
						<label>Місце проведення: </label>
						<strong><c:out value="${listeventview.venue}"></c:out></strong>
					</p>
					
					<p>
						<label>Комендант: </label>
						<strong>
							<c:out value="${listeventview.lastnamekom}"></c:out>
							<c:out value="${listeventview.firstnamekom}"></c:out>
						</strong>
					</p>					


					<p>
						<label>Організатори: </label>
						<strong><c:out value="${listeventview.nameorganizer}"></c:out></strong>
					</p>
					
					<p>
						<label>Лікар:</label>
						<strong>
							<c:out value="${listeventview.lastnamedoc}"></c:out>
							<c:out value="${listeventview.firstnamedoc}"></c:out>
						</strong>
					</p>
				</fieldset>
			</div>
			
			<div class ="participants" >
			
				<fieldset><legend><b>Учасники</b></legend>
					<p>
						<label>Кількість учасників: </label>
						<strong><input type="number" name="contparticip"  min="0" id="idcountpaticip" value="${listeventview.numbparticip}"> осіб</strong>
						
					</p>
					<label>Кількість учасників по станицях</label>
					<br>
							<div id='participant'>
							<label>Станиця: </label>
							
							<select class="classselstan" name="stan">
									<option value="0">Вибрати станицю</option>
									<c:forEach items="${liststanytsya}" var="liststanytsya">
										<option value="${liststanytsya.id}">
											<c:out value="${liststanytsya.namestan}"></c:out>
										</option>
									</c:forEach>
								</select> 
							<label> Кількість: </label><input type="number" min=0 value="0" name="countpart">
							</div>
							<br>							
							<input type="button" value="Додати кількість учасників" id="addparticipant">						
				</fieldset>
			</div>
			<div class ="provid" >
			
				<fieldset><legend><b>Провід заходу</b></legend>
				
					<label>Комендант: </label>
					<strong>
							<c:out value="${listeventview.lastnamekom}"></c:out>
							<c:out value="${listeventview.firstnamekom}"></c:out>
						</strong>
					<br>
					
					<table border="1" class="leader" id="idleadership">
						<tr>
							<th>Провід</th>
							<th>Прізвище</th>
							<th>Ім'я</th>
						</tr>
						<tr>
							<td>
								<select name="selectprovid" class="selectleader">
									<option value="0">Виберіть провід</option>
									<c:forEach items="${listleadership}" var="listleadership">
										<option value="${listleadership.id}">
											<c:out value="${listleadership.namelider}"></c:out>
										</option>
									</c:forEach>
								</select>
								<input type="button" value="+" class="addnameprovid">
							</td>
							<td>
								<input type="text" name="firstname" class="firstname" width="10px">
							</td>
							<td>
								<input type="text" name="lastname" class="lastname" width="10px">
							</td>
						</tr>
					</table>
					<br>
					<input type="button" value="Додати провід" id="addprovid">			
					<div id="id_dialog_provid" title="Додати провід заходу">
										<fieldset>
											<label>Назва посади в проводі</label>
											<br>
											<input type="text" id="idnameprovid">
											<br>
											<div class="notcorrect"><p></p></div>
										</fieldset>
					</div>
				</fieldset>
			</div>
			
			<div class="estimate">
				<fieldset><legend>Кошторис витрати</legend>
					<table border="1" class="sales">
						<tr>
							<th>Стаття витрат</th>
							<th>Вкладка</th>
							<th>КПС</th>
							<th>Бюджет</th>
							<th>Спонсор</th>
							<th>Інше</th>
						</tr>
						<c:forEach items="${listestimpojo}" var="listestimpojo">
						<tr>
						
							<td>
								<input type="hidden" value="${listestimpojo.costitemid}" class="costiteminput">
								<input type="hidden" value="${listestimpojo.id}" name="estimid${listestimpojo.id}">
								<select class="selcostitem" name="costitem0${listestimpojo.id}" id="selcost${listestimpojo.costitemid}">
								
									<option value="0">Виберіть статтю витрат</option>
									<c:forEach items="${listcost}" var="listcost">
										<option value="${listcost.id}">
											<c:out value="${listcost.namecostitem}"></c:out>
										</option>
									</c:forEach>
								</select>
								<input type="button" value="+" class="addcostitem">
									
							</td>
							<td><input type="number" name="sumpart0${listestimpojo.id}" value="${listestimpojo.sumparticipant}" min="0"></td>
							<td><input type="number" name="sumplast0${listestimpojo.id}" value="${listestimpojo.sumplast}" min="0"></td>
							<td><input type="number" name="sumbudget0${listestimpojo.id}" value="${listestimpojo.sumbudget}" min="0"></td>
							<td><input type="number" name="sumsponsor0${listestimpojo.id}" value="${listestimpojo.sumsponsor}" min="0"></td>
							<td><input type="number" name="sumother0${listestimpojo.id}" value="${listestimpojo.sumother}" min="0"></td>
						
						</tr>
						</c:forEach>
					</table>
					<br>
					<input type="button" value="Додати нову статтю" id="add">
					<div id="id_dialog_costitem" title="Стаття витрат">
										<fieldset>
											<label>Назва статті витрат</label>
											<br>
											<input type="text" id="idcositem">
											<br>
											<div class="notcorrect"><p></p></div>
										</fieldset>
									</div>
				</fieldset>
			</div>
				<div class ="creativereport" >
			
				<fieldset><legend><b>Творчий звіт</b></legend>
				<p>Опишіть:</p>
					<label>Які завдання планувалося виконати під час проведення заходу, які завдання не було виконано</label>
					<textarea rows="10" cols="10" name="tasks"></textarea>
					<label>Як було висвітлено захід, щодо проведення програми (ЗМІ)</label>
					<textarea rows="10" cols="10" name="informmedia"></textarea>
					<label>Рекомендації наступному коменданту</label>
					<textarea rows="10" cols="10" name="recomendation"></textarea>
					<label>Інше</label>
					<textarea rows="10" cols="10" name="other"></textarea>
					<label>Висновок</label>
					<textarea rows="10" cols="10" name="conclusion"></textarea>
					
				</fieldset>
			</div>
			
			<div class ="photos" >
			
				<fieldset><legend><b>Фотографії заходу</b></legend>
				
					<label>Додайте декілька фотографій</label>				
					
				
				<br>
			 	<input type="file" name="photosadvert" id="addphoto" multiple="multiple">
				<p id="namefiles"></p>
				
				</fieldset>
			</div>
			
			
			<br>
			<div class="notcorrect"><p></p></div>
			<input type="submit" value="Зберегти дані" name="savereport" class="ui-button ui-widget" id="saveReport">
				<div id="dialog_save" title="Дані збережені">
										<fieldset>											
											<h1>Вишкіл зголошений</h1>											
											<h2>Ключ для редагування відправлений на e-mail коменданта</h2>
										</fieldset>
									</div>
									</c:forEach>
		</form>
	</div>
</main>
<!-- /MAIN SECTION -->
<!-- FOOTER -->
<!-- <footer class="ui-widget-header ui-corner-bottom form_pad">
	<div class="ui-widget-header ui-corner-bottom form_pad">
		<p align="center">Copyright</p>
	</div>
</footer>-->
<%@ include file = "footer.jsp" %>
<!-- /FOOTER -->
</body>
</html>