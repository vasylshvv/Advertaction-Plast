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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
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
	<script type="text/javascript" src="script/infocommandant.js"></script>
	<script type="text/javascript" src="script/changestatus.js"></script>
	<script type="text/javascript" src="script/inforecommned.js"></script>
	<script type="text/javascript">
		
	jQuery(function(){
		$(".report").click(function(){
				var c = $(this).val();
				window.location = "report.html?idrep="+c;
		});
		$(".look").click(function(){
			var l = $(this).val();
			window.location = "review.html?idreview="+l;
		});
	
		$('#mytable .customerIDCell').each(function(){
			var statusid =  $(this).find('input[type="hidden"]').val();
			
				  if(statusid == 1) {
					 $(this, '.customerIDCell').css('background-color', '#FF0000');
					 $(this, '.customerIDCell').css('color', '#FFFFFF');
				  } else if(statusid == 2){
					  $(this, '.customerIDCell').css('background-color', '#FFFF00');
					  $(this, '.customerIDCell').css('color', '#000000');
				  } else if(statusid == 3){
					  $(this, '.customerIDCell').css('background-color', '#008000');
					  $(this, '.customerIDCell').css('color', '#FFFFFF');
				  } else if(statusid == 4){
					  $(this, '.customerIDCell').css('background-color', '#808080');
					  $(this, '.customerIDCell').css('color', '#FFFFFF');
				  }
				});
	});
	</script>
</head>
<body>
<%@ include file = "header.jsp" %>
<!-- HEADER -->

	<div class="ui-widget-header ui-corner-top form_pad">
		<h1 align="center">Крайова булава УПЮ</h1>
		<h2 align="center">Список зголошених акцій</h2>
	</div>
<!-- /HEADER -->
<!-- NAVIGATION -->
	<div>
		
	</div>
<!-- /NAVIGATION -->
<!-- MAIN SECTION -->
<main>
	<div>
	
		<table border="1" id="mytable">
			<tr>
				<th>Назва</th>
				<th>Дата проведення</th>
				<th>Вид заходу</th>
				<th>Місце проведення</th>
				<th>Комендант</th>
				<th>Статус зголошення</th>
				<th>Файл</th>
				<th>Звіт</th>
				<th>Перегляд</th>
			</tr>
			<c:forEach items="${listevent}" var="listevent">
			<tr>
				<td>
				
				<c:out value="${listevent.advertname}"></c:out></td>
				
				
				
				<td>
					<fmt:formatDate type="date" pattern="dd.MM.yyyy" value="${listevent.datefromadvert}"/>
						<c:out value="${datefromadvert}"></c:out>
						-
					<fmt:formatDate type="date" pattern="dd.MM.yyyy" value="${listevent.datetoadvert}"/>
						<c:out value="${datetoadvert}"></c:out>
				</td>
				<td><c:out value="${listevent.nametypeaction}"></c:out></td>
				<td><c:out value="${listevent.venue}"></c:out></td>
				<td><c:out value="${listevent.firstnamekomendant} ${listevent.lastnamekomendant}"></c:out>
					<button value="${listevent.idkomendant}" class="infcomand">i</button>
				</td>
				<td class="customerIDCell">
						<div >
							<input type="hidden" value="${listevent.idstatus}"> <c:out value="${listevent.status}"></c:out>
						</div>
						<div align="right">
							<button value="${listevent.id}" class="recommendt">i</button>
						</div>

				</td>
				<td>
				<a href="http://81.4.121.112:8080/advertaction/files/<fmt:formatDate type="date" pattern="dd.MM.yyyy" value="${listevent.registrdate}"/>_<c:out value="${listevent.advertnameeng}"/>.pdf" download>
    							<img src="images/filepdf.png" alt="save">
    						</a></td>
				<td><button class="report" value="${listevent.id}">Заповнити звіт</button></td>
				<td><button class="look" value="${listevent.id}">Перелянути\ Змінити</button></td>
			</tr>
			</c:forEach>
		</table>
		<div id="dialoginfcom" title="Інформація про коменданта"></div>
		<div id="dialoginfrecom" title="Інофрмація по зголошенню"></div>
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