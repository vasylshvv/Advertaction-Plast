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
<!DOCTYPE html>
<html>
<head>
	<title>Зголошення акції</title>
	<meta charset="UTF-8">
 	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="jquery-ui-1.12.1.custom/jquery-ui.css">
	<script type="text/javascript"></script>
	<script src="jquery/jquery-1.12.0.min.js"></script>
	<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	<script type="text/javascript">
	 jQuery(function(){
		var idsts = $("#idstatus").val();
		$('#selstatus').val(idsts);
	 });
	
	</script>
	
</head>
<body>
<%@ include file = "header.jsp" %>
<!-- HEADER -->

	<div class="ui-widget-header ui-corner-top form_pad">
		<h1 align="center">Крайова булава УПЮ</h1>
		<h2 align="center">Зголошення акції</h2>
	</div>
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
	<form action="review.html" method="get">
		<div class ="name" >
		
			<c:forEach items="${listEventView}" var="listeventview">
				<fieldset><legend><b>Головна</b></legend>
					<input type="hidden" value="${listeventview.id}" name="idevent">
					<input type="hidden" value="${listeventview.idstatus}" id="idstatus">
					<label>Назва заходу*</label>
					<c:out value="${listeventview.advertname}"></c:out>
					<br>
					<label>Дата проведення</label>
					<label>з </label><c:out value="${listeventview.datefromadvert}"></c:out><label>по </label><c:out value="${listeventview.datetoadvert}"></c:out>
					<br>
					<label>Вид заходу</label><c:out value="${listeventview.nametypeaction}"></c:out>
					<br>					
					<label>Місце проведення </label><c:out value="${listeventview.venue}"></c:out>
					<br>					
					<label>Комендант</label><c:out value="${listeventview.lastnamekom} ${listeventview.firstnamekom}"></c:out>
					<br>					
					<label>Організатори</label><c:out value="${listeventview.nameorganizer}"></c:out>
					<br>					
					<label>Лікар</label><c:out value="${listeventview.lastnamedoc} ${listeventview.firstnamedoc}"></c:out>
					<br>					
					<label>Програма</label><c:out value="${listeventview.program}"></c:out>
					<br>					
					<label>Мета заходу</label><c:out value="${listeventview.purpose}"></c:out>
					<br>					
					<label>Кількість учасників</label><c:out value="${listeventview.numbparticip}"></c:out>
					<br>					
					<label>Вік учасників</label><c:out value=" від ${listeventview.ageparticipfrom} до ${listeventview.ageparticipto}"></c:out>
					<br>					
					<label>Актуальність заходу</label><c:out value="${listeventview.topicality}"></c:out>
					<br>					
					<label>Очікувані результати</label><c:out value="${listeventview.expectresult}"></c:out>
					<br>					
					<label>Вкладка</label><c:out value="${listeventview.sumparticip}"></c:out>
					<br>					
					<label>Інша інформація</label><c:out value="${listeventview.otherinfo}"></c:out>
					
				</fieldset>
				</c:forEach>
			</div>
			<div>
				<select id="selstatus" name="selstatus">
				<c:forEach items="${listStatusAdvert}" var="liststatusadvert">
					<option value="${liststatusadvert.id}"><c:out value="${liststatusadvert.description}"></c:out>	
				</c:forEach>
				</select>
			</div>
			<div><textarea rows="10" cols="100" name="recommend"></textarea></div>
			<div><input type="submit" name="savestatus" value="Зберегти"></div>
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