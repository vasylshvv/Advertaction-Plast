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
	<link rel="stylesheet" type="text/css" href="vendor/vendor.css">
	<link rel="stylesheet" type="text/css" href="css/style_new.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="jquery-ui-1.12.1.custom/jquery-ui.css">
	

	
	<script type="text/javascript"></script>
	<script src="jquery/jquery-1.12.0.min.js"></script>
	<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	<script type="text/javascript" src="script/datefromto.js"></script>
	
	<script type="text/javascript">
		
	jQuery(function(){
		var typeaction = $("#typeactionid").val();
		var komendant = $("#komendantid").val();
		var organizer = $("#organizerid").val();
		var doctor = $("#doctorid").val();
		var itemcost; //= $(".costiteminput").val();
		
		var finan = $("#fin").val();
		if(finan == 1){
			finan = 'ТАК';
		} else {
			finan = 'НІ';
		}
	
		$( ".costiteminput" ).each(function() {
			itemcost = $( this ).val();
			$("#selcost"+itemcost+" option[value=" + itemcost + "]").attr('selected', 'true');
		});
		
		//alert(itemcost);
		$("#selecttype option[value=" + typeaction + "]").attr('selected', 'true');
		$("#idselkomendant option[value=" + komendant + "]").attr('selected', 'true');
		$("#idselorg option[value=" + organizer + "]").attr('selected', 'true');
		$("#selectdoc option[value=" + doctor + "]").attr('selected', 'true');
		$("#agvfin").html(finan);
		
	});
	</script>
</head>
<body>
<%@ include file = "header.jsp" %>
	<div class="ui-widget-content form_pad">
		<h2>Критерії на коменданта</h2>
		<ul>
			<li>1. Комендантом заходу Пласту може бути дійсний член Пласту - НСОУ (член Уладу Старших Пластунів, Уладу Пластунів Сеньйорів, заприсяжений та досяг 21 років) затверджений Крайовим проводом, як комендант даного заходу.</li>
			<li>2. Комендант несе безпосередню відповідальність за проведення заходу відповідно до затвердженої програми; безпеку життя та здоров’я учасників заходу; звітування про проведення заходу.</li>
			<li>3.Перед початком заходу комендант (член проводу) повинен провести інструктаж по правилах техніки безпеки учасникам заходу.</li>
			<li>4. Під час проведення заходу обов’язково повинен бути присутній фахівець в галузі медицини, який в разі необхідності, зможе надати першу медичну допомогу.</li>
			<li>5.Про проведений захід комендант зобов’язаний подати фінансовий та творчий звіти у тритижневий термін після проведення заходу.</p></li>
		</ul>
		<%--<h2>Критерії для учасників</h2>--%>
		<%--<h2>Вимоги до вишколу</h2>--%>
	</div>
	<div class="ui-widget-content form_pad">
		<c:forEach items="${listeventview}" var="listeventview">
			<div class ="name" >
					<fieldset>
						<legend><b>Головна</b></legend>

						<p>
							<label>Назва заходу:</label>
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
							<label>Рівень заходу: </label>
							<strong><c:out value="${listeventview.levelname}"></c:out></strong>
						</p>

						<p>
							<label>Державне фінансування</label>
							<input id="fin" type="hidden" value="<c:out value="${listeventview.goverfinan}"></c:out>">
							<strong id="agvfin"></strong>
						</p>

						<p>
							<label>Місце проведення</label>
							<strong><c:out value="${listeventview.venue}"></c:out></strong>
						</p>
					</fieldset>

				</div>
				<div class="organization">
					<fieldset>
						<legend>Організатори</legend>
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
				<div class="program">
					<fieldset>
						<legend>Програма</legend>

						<label>Програма</label>
						<br>
						<strong>
							<textarea rows="10" cols="50" readonly="readonly">
								<c:out value="${listeventview.program}"></c:out>
							</textarea>
						</strong>
						<br>

						<label>Мета заходу</label>
						<br>
						<strong>
							<textarea rows="10" cols="50" readonly="readonly">
								<c:out value="${listeventview.purpose}"></c:out>
							</textarea>
						</strong>
						<p>
							<label>Кількість учасників: </label>
							<strong><c:out value="${listeventview.numbparticip}"></c:out></strong>
						</p>

						<p>
							<label>Вік учасників: </label>
							<label>з </label>
							<strong><c:out value="${listeventview.ageparticipfrom}"></c:out></strong>
							<label>по </label>
							<strong><c:out value="${listeventview.ageparticipto}"></c:out></strong>
						</p>

						<label>Актуальність заходу</label>
						<br>
						<strong>
							<textarea rows="10" cols="50" readonly="readonly">
								<c:out value="${listeventview.topicality}"></c:out>
							</textarea>
						</strong>
						<br>

						<label>Очікувані результати</label>
						<br>
						<strong>
							<textarea rows="10" cols="50" readonly="readonly">
								<c:out value="${listeventview.expectresult}"></c:out>
							</textarea>
						</strong>

						<p>
							<label>Вкладка</label>
							<strong><c:out value="${listeventview.sumparticip}"></c:out> грн.</strong>
						</p>
					</fieldset>
				</div>
				<div class="other">
					<fieldset><legend>Інші відомості</legend>
						<strong>
							<textarea rows="10" cols="50" readonly="readonly">
								<c:out value="${listeventview.otherinfo}"></c:out>
							</textarea>
						</strong>
					</fieldset>
				</div>
			</c:forEach>
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

							<td><c:out value="${listestimpojo.namecostitem}"></c:out></td>
							<td><c:out  value="${listestimpojo.sumparticipant}"></c:out></td>
							<td><c:out  value="${listestimpojo.sumplast}"></c:out></td>
							<td><c:out  value="${listestimpojo.sumbudget}"></c:out></td>
							<td><c:out  value="${listestimpojo.sumsponsor}"></c:out></td>
							<td><c:out  value="${listestimpojo.sumother}"></c:out></td>

						</tr>
						</c:forEach>
					</table>
					<br>
				</fieldset>
			</div>
		<div>
	<%@ include file = "footer.jsp" %>
</body>
</html>