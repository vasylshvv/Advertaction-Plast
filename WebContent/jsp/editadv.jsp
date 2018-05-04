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
	<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	<script type="text/javascript" src="script/datefromto.js"></script>
	<script type="text/javascript" src="script/addnewtype.js"></script>
	<script type="text/javascript" src="script/addnewcommandant.js"></script>
	<script type="text/javascript" src="script/addnewstan.js"></script>
	<script type="text/javascript" src="script/addnewkurin.js"></script>
	<script type="text/javascript" src="script/addneworganizer.js"></script>
	<script type="text/javascript" src="script/addnewdoctor.js"></script>
	<script type="text/javascript" src="script/addnewcostitem.js"></script>
	<script type="text/javascript" src="script/validedit.js"></script>
	<script type="text/javascript">
		
	jQuery(function(){
	    var counter = 1;
	    jQuery('#add').click(function(event){
	        event.preventDefault();
	        counter++;
	        var selected = '<select class="selcostitem" name="costitem'+counter+'"><option value="0">Виберіть статтю витрат</option><c:forEach items="${listcost}" var="listcost"><option value="${listcost.id}"><c:out value="${listcost.namecostitem}"></c:out></option></c:forEach></select>';
	        var row = jQuery('<tr><td>'+selected+' <input type="button" value="+" class="addcostitem"/></td>'+
	        				'<td><input type="number" name="sumpart'+counter+'" value="0"></td>'+
	        				'<td><input type="number" name="sumplast'+counter+'" value="0"></td>'+
	        				'<td><input type="number" name="sumbudget'+counter+'" value="0"></td>'+
	        				'<td><input type="number" name="sumsponsor'+counter+'" value="0"></td>'+
	        				'<td><input type="number" name="sumother'+counter+'" value="0"></td>'+
	        		'</tr>');
	        jQuery('table.sales').append(row);
	    });
	});
	</script>
	<script type="text/javascript">
		
	jQuery(function(){
		var typeaction = $("#typeactionid").val();
		var komendant = $("#komendantid").val();
		var organizer = $("#organizerid").val();
		var doctor = $("#doctorid").val();
		if(doctor == ""){
			doctor = 0;
		}
		var levelaction = $("#levelactionid").val();
		
		var itemcost; //= $(".costiteminput").val();
		$( ".costiteminput" ).each(function() {
			itemcost = $( this ).val();
			$("#selcost"+itemcost+" option[value=" + itemcost + "]").attr('selected', 'true');
		});
		
		//alert(itemcost);
		$("#selecttype option[value=" + typeaction + "]").attr('selected', 'true');
		$("#idselkomendant option[value=" + komendant + "]").attr('selected', 'true');
		$("#idselorg option[value=" + organizer + "]").attr('selected', 'true');
		$("#selectlevel option[value=" + levelaction + "]").attr('selected', 'true');
		$("#selectdoc option[value=" + doctor + "]").attr('selected', 'true');
		
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
<!-- /HEADER -->
<!-- NAVIGATION -->
	<div class="ui-widget-content form_pad">
		<h2>Критерії на коменданта</h2>
		<ul>
			<li>1. Комендантом заходу Пласту може бути дійсний член Пласту - НСОУ (член Уладу Старших Пластунів, Уладу Пластунів Сеньйорів, заприсяжений та досяг 21 років) затверджений Крайовим проводом, як комендант даного заходу.</li>
			<li>2. Комендант несе безпосередню відповідальність за проведення заходу відповідно до затвердженої програми; безпеку життя та здоров’я учасників заходу; звітування про проведення заходу.</li>
			<li>3.Перед початком заходу комендант (член проводу) повинен провести інструктаж по правилах техніки безпеки учасникам заходу.</li>
			<li>4. Під час проведення заходу обов’язково повинен бути присутній фахівець в галузі медицини, який в разі необхідності, зможе надати першу медичну допомогу.</li>
			<li>5.Про проведений захід комендант зобов’язаний подати фінансовий та творчий звіти у тритижневий термін після проведення заходу.</p></li>
		</ul>
		<h2>Критерії для учасників</h2>
		<h2>Вимоги до вишколу</h2>
	</div>
<!-- /NAVIGATION -->
<!-- MAIN SECTION -->
<main>
	<div class="ui-widget-content form_pad">
		<form action="editadv.html" method="post" id="sendAdvert">


			<div class ="name" >
					
			
				<fieldset><legend><b>Головна</b></legend>
				<c:forEach items="${listeventedit}" var="listeventedit">
					<label>Назва заходу*</label>
					<br>
					<input type="hidden" name="idadvert" id="iddvert" value="${listeventedit.id}">
					<input type="text" name="advertname" id="nameadvert" value="${listeventedit.advertname}">
					<span class="error" id="eradvname">Заповніть правильно поле</span>
					<p></p>
					
					<label>Дата проведення</label>
					<br>
					<fmt:formatDate value="${listeventedit.datefromadvert}" pattern="dd.MM.yyyy" var="datefrom" />
					<label>з </label><input type="text" class="datepicker" name="datefrom" id="iddatefrom" value="${datefrom}">
					<fmt:formatDate value="${listeventedit.datetoadvert}" pattern="dd.MM.yyyy" var="dateto" /> 
					<label>по </label><input type="text" class="datepicker" name="dateto" id="iddateto" value="${dateto}">
					<span class="error" id="fromdateto">Заповніть дату з календаря</span>
					<span class="error" id="equaldate">Дата закінчення має бути більшою за дату проведення</span>
					<p></p>
					<input type="hidden" value="${listeventedit.typeactionid}" id="typeactionid">
					<input type="hidden" value="${listeventedit.komendantid}" id="komendantid">
					<input type="hidden" value="${listeventedit.organizerid}" id="organizerid">
					<input type="hidden" value="${listeventedit.doctorid}" id="doctorid">
					<input type="hidden" value="${listeventedit.levelactionid}" id="levelactionid">
					<label>Вид заходу</label>
					<br>
					
					<select id="selecttype" name="typeadvert">
					
						<option value="0">Вибрати вид заходу</option>
						<c:forEach items="${listtypeaction}" var="listtypeaction">						
							<option value="${listtypeaction.id}" >
								<c:out value="${listtypeaction.nametypeaction}"></c:out>
							</option>						
						</c:forEach>
					</select>
					<input type="button" value="+" id="addtype">
					<span class="error" id="typsel">Виберіть тип вишколу</span>
					<div id="dialog_type" title="Тип вишколу">
						<fieldset>
							<label>Новий тип вишколу</label>
							<br>
							<input type="text" name="newtype" id="idtype">
							<br>
							<div class="notcorrect"><p></p></div>
						</fieldset>
					</div>
					<p></p>
					
					<label>Рівень заходу</label>
					<br>
					<select id="selectlevel" name="leveladvert">
						<option value="0">Вибрати рівень заходу</option>
						<c:forEach items="${listlevelaction}" var="listlevelaction">
							<option value="${listlevelaction.id}" >
								<c:out value="${listlevelaction.namelevel}"></c:out>
							</option>
						</c:forEach>
					</select>
					<span class="error" id="levelsel">Виберіть рівень заходу</span>
					<p></p>
					
					<label>Місце проведення</label>
					<br>
					<input type="text" name="venue" id="idvenue" value="${listeventedit.venue}">
					<span class="error" id="errvenue">Заповніть правильно поле</span>
					<p></p>
					<label>Державне фінансування</label> 
					<br>						
					    <input type="checkbox" value="<c:out value="${listeventedit.goverfinan}"/>" ${listeventedit.goverfinan == 1 ? 'checked' : 0} name="goverfin">
					    <b style="color: red">Відзначте, якщо захід подається на державне фінансування</b>
					</c:forEach>
					<p></p>
					
				</fieldset>
					
			</div>
			<div class="organization">					
				<fieldset><legend>Організатори</legend>
					<label>Комендант</label>
					<br>
					<select id="idselkomendant" name="komendant">
						<option value="0">Вибрати з списку</option>
						<c:forEach items="${listkomendant}" var="listkomendant">
							<option value="${listkomendant.id}"><c:out value="${listkomendant.lastname} ${listkomendant.firstname}"></c:out></option>
						</c:forEach>
					</select>
					<input type="button" value="+" id="add_commandant">
					<span class="error" id="komendt">Виберіть коменданта вишколу</span>
						<div id="dialog_commandant" title="Комендант">
							<fieldset>
								<label style="font-size:15px">Прізвище</label><label>*</label>
								<br>
								<input type="text" name="lasttname" id="idlastname">
								<br>
								<label>Ім'я</label>
								<br>
								<input type="text" name="firstname" id="idfirstname">
								<br>
								<label>дата народження</label>
								<br>
								<input type="text" class="datepicker" name="birthday" id="idbirthday">
								<br>
								<label>ступінь в пласті</label>
								<br>
								<select id="idselstup">
									<option value="0">Виберіть ступінь</option>
									<c:forEach items="${liststupin}" var="liststupin">
									<!-- <input type="hidden" value="${liststupin.longname}" id="idlongname"/>-->
										<option value="${liststupin.id}">
											<c:out value="${liststupin.shortname}"></c:out>
										</option>
									</c:forEach>
								</select>
								<br>
								<label>Станиця</label>
								<br>
								<select id="idselstan">
									<option value="0">Вибрати станицю</option>
									<c:forEach items="${liststan}" var="liststan">
										<option value="${liststan.id}">
											<c:out value="${liststan.namestan}"></c:out>
										</option>
									</c:forEach>
								</select> 
								<input type="button" value="+" id="addstan">
									<div id="dialog_stanyt" title="Станиця">
										<fieldset>
											<label>Введіть станицю</label>
											<br>
											<input type="text" name="namestan" id="stan">
											<br>
											<div class="notcorrect"><p></p></div>
										</fieldset>
									</div>
								<br>
								<label>Курінь УСП/УПС</label>
								<br>
								<select id="idselkurin">
									<option value="0">Вибрати курінь</option>
									<c:forEach items="${listkurin}" var="listkurin">
										<option value="${listkurin.id}">
											<c:out value="${listkurin.namekurin}"></c:out>
										</option>
									</c:forEach>
								</select>
								<input type="button" value="+" id="addkurin">
									<div id="dialog_kurin" title="Приналежність до куреня">
										<fieldset>
											<label>Введіть курніь</label>
											<br>
											<input type="text" name="namekurin" id="idkurin">
											<br>
											<div class="notcorrect"><p></p></div>
										</fieldset>
									</div>
								<br>
								<label>Вишкіл ЛШ\ШБ</label>
								<br>
								<select id="idselvyshkil">
									<option value="0">Вибрати вишкіл</option>
									<c:forEach items="${listvyshkil}" var="listvyshkil">
										<option value="${listvyshkil.id}">
											<c:out value="${listvyshkil.name}"></c:out>
										</option>
									</c:forEach>
								</select>
								<br>
								<label>Ступінь КВ</label>
								<br>
								<select id="idstupkv">
									<option value="0">Вибрати ступніь в КВ</option>
									<c:forEach items="${listkv}" var="listkv">
										<option value="${listkv.id}">
											<c:out value="${listkv.name}"></c:out>
										</option>
									</c:forEach>
								</select>
								<br>
								<label>Контактний номер</label>
								<br>
								<input type="tel" id="idtelnumb">
								<br>
								<label>Контактний e-mail</label>
								<br>
								<input type="email" id="idemail">
								<br>
								<div class="notcorrect"><p></p></div>
							</fieldset>
						</div>
					
					<p></p>
					
					<label>Організатори</label>
					<br>
					<select id="idselorg" name="organizer">
						<option value="0">Вибрати з списку</option>
						<c:forEach items="${listorgan}" var="listorgan">
							<option value="${listorgan.id}">
								<c:out value="${listorgan.nameorganizer}"></c:out>
							</option>
						</c:forEach>
					</select>
					<input type="button" value="+" id="addorg">
					<span class="error" id="organ">Виберіть організатоів</span>
						<div id="id_dialog_org" title="Організатори">
							<fieldset>
								<label>Ввести організаторів заходу</label>
								<br>
								<input type="text" id="idorganizer">
								<br>
								<div class="notcorrect"><p></p></div>
							</fieldset>
						</div>
					<p></p>
					
					<label>Лікар</label>
					<br>
					<select id="selectdoc" name="doctor">
						<option value="0">Вибрати з списку</option>
						<c:forEach items="${listdoctor}" var="listdoctor">
							<option value="${listdoctor.id}">
								<c:out value="${listdoctor.lastnamedoc} ${listdoctor.firstnamedoc}"></c:out>
							</option>
						</c:forEach>
					</select>
					<input type="button" value="+" id="adddoc">
						<div id="id_dialog_doctor" title="Лікар">
							<fieldset>
								<label>Прізвище</label>
								<br>
								<input type="text" id="lastnamedoc">
								<br>
								<label>Ім'я</label>
								<br>
								<input type="text" id="firstnamedoc">
								<br>
								<label>Тип</label>
								<br>
								<select id="seltypedoc">
									<option value="0">Вибрати</option>
									<c:forEach items="${listtypedoc}" var="listtypedoc">
										<option value="${listtypedoc.id}">
											<c:out value="${listtypedoc.nametypedoctor}"></c:out>
										</option>
									</c:forEach>
								</select>
								<br>
								<label>Спеціалність</label>
								<br>
								<input type="text" id="specdoc">
								<br>
								<label>контактний номер</label>
								<br>
								<input type="tel" id="teldoc">
								<br>
								<label>контактний e-mail</label>
								<br>
								<input type="email" id="emaildoc">
								<br>
								<div class="notcorrect"><p></p></div>
							</fieldset>
						</div>
				</fieldset>
			</div>
			<div class="program">
				<fieldset><legend>Програма</legend>
				<c:forEach items="${listeventedit}" var="listeventedit">
					<label>Програма</label>
					<br>
					<textarea rows="10" cols="50" name="program" id="idprogram"><c:out value="${listeventedit.program}"></c:out></textarea>
					<span class="error" id="prog">Заповніть програму</span>
					<p></p>
					
					<label>Мета заходу</label>
					<br>
					<textarea rows="10" cols="50" name="purpose" id="idpurpose"><c:out value="${listeventedit.purpose}"></c:out></textarea>
					<span class="error" id="purps">Заповніть мету заходу</span>
					<p></p>
					
					<label>Кількість учасників</label>
					<br>
					<input type="number" name="countpaticip"  min="0" id="idcountpaticip" value="${listeventedit.numbparticip}">
					<p></p>
					
					<label>Вік учасників</label>
					<br>
					<label>з</label><input type="number" name="fromoldpat"  min="0" multiple="multiple" id="idfromoldpat" value="${listeventedit.ageparticipfrom}">
					<label>по</label><input type="number" name="tooldpat"  min="0" id="idtooldpat" value="${listeventedit.ageparticipto}">
					<p></p>
					
					<label>Актуальність заходу</label>
					<br>
					<textarea rows="10" cols="50" name="topicality" id="idtopicality"><c:out value="${listeventedit.topicality}"></c:out></textarea>
					<span class="error" id="actl">Заповніть актуальність заходу</span>
					<p></p>
					
					<label>Очікувані результати</label>
					<br>
					<textarea rows="10" cols="50" name="expectresult" id="idexpectresult"><c:out value="${listeventedit.expectresult}"></c:out></textarea>
					<span class="error" id="expect">Заповніть очікувані результати</span>
					<p></p>
					
					<label>Вкладка</label>
					<br>
					<input type="number" name="mainsumprt" id="idmainsumprt" value="${listeventedit.sumparticip}" min="0">
					
					<p></p>
					</c:forEach>
				</fieldset>
			</div>
			<div class="other">
				<fieldset><legend>Інші відомості</legend>
				<c:forEach items="${listeventedit}" var="listeventedit">
					<label>Інші відомості</label>
					<br>
					<textarea rows="10" cols="50" name="otherinfo"><c:out value="${listeventedit.otherinfo}"></c:out></textarea>
					<p></p>
				</c:forEach>
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
								<select class="selcostitem" name="costitem0${listestimpojo.costitemid}" id="selcost${listestimpojo.costitemid}">
								
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
			<br>
			<div class="notcorrect"><p></p></div>
			
			<input type="submit" value="Зберегти дані" name="updatevents" class="ui-button ui-widget" id="updatedata">
			
	
		</form>
		
	</div>
</main>
<!-- /MAIN SECTION -->
<!-- FOOTER -->
<!-- 
<footer class="ui-widget-header ui-corner-bottom form_pad">
	<div class="ui-widget-header ui-corner-bottom form_pad">
		<p align="center">Copyright</p>
	</div>
</footer>-->
<%@ include file = "footer.jsp" %>
<!-- /FOOTER -->
</body>
</html>