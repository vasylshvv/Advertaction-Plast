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
	<link rel="icon" href="images/favicon.ico" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="vendor/vendor.css">
	<link rel="stylesheet" type="text/css" href="css/style_new.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="jquery-ui-1.12.1.custom/jquery-ui.css">

	<script src="jquery/jquery-1.12.0.min.js"></script>
	<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	<script type="text/javascript" src="script/infocommandant.js"></script>
	<script type="text/javascript" src="script/inforecommned.js"></script>
	<script type="text/javascript" src="script/editadvert.js"></script>
	<script type="text/javascript" src="script/reportadv.js"></script>
	<script type="text/javascript" src="script/filters.js"></script>
	<script type="text/javascript">

      jQuery(function(){
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
	<form id="filters">
		<fieldset>
			<legend><b>Фільтри</b></legend>
			<div class="filters-search">
				<label>Пошук</label>
				<input id="search-events" type="search" placeholder="Введіть назву заходу" />
			</div>
			<div id="listtype" class="col-xs-3">
				<label>Вид заходу</label>
				<select id="selecttype">
					<option value="0">Вибрати вид заходу</option>
					<c:forEach items="${listtype}" var="listtype">
						<option value="${listtype.id}" >
							<c:out value="${listtype.nametypeaction}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
			<div id="listlevel" class="col-xs-3">
				<label>Рівент заходу</label>
				<select id="selectlevel">
					<option value="0">Вибрати рівень заходу</option>
					<c:forEach items="${listlevel}" var="listlevel">
						<option value="${listlevel.id}" >
							<c:out value="${listlevel.namelevel}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
			<div id="listmonth" class="col-xs-3">
				<label>Місяць проведення заходу</label>
				<select id="selectmonth">
					<option value="0">Вибрати місяць</option>
					<option value="01">Січень</option>
					<option value="02">Лютий</option>
					<option value="03">Березень</option>
					<option value="04">Квітень</option>
					<option value="05">Травень</option>
					<option value="06">Червень</option>
					<option value="07">Липень</option>
					<option value="08">Серпень</option>
					<option value="09">Вересень</option>
					<option value="10">Жовтень</option>
					<option value="11">Листопад</option>
					<option value="12">Грудень</option>
				</select>
			</div>
			<button type="submit" id="filters-submit">Фільтрувати</button>
		</fieldset>
	</form>
	<table border="1" id="mytable">
		<thead>
		<tr>
			<th>Назва</th>
			<th>Дата проведення</th>
			<th>Вид заходу</th>
			<th>Місце проведення</th>
			<th>Комендант</th>
			<th>Статус зголошення</th>
			<th>Файл зголошення</th>
			<th>Редагувати/Перегляд</th>
			<th>Звіт</th>
			<th>Статус звітування</th>
			<th>Файл звітування</th>
			<th>Редагування/перегляд звітування</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listevent}" var="listevent">
			<fmt:formatDate type="date" pattern="MM" value="${listevent.datefromadvert}" var="datefrom"/>
			<fmt:formatDate type="date" pattern="MM" value="${listevent.datetoadvert}" var="dateto"/>
			<tr data-type="${listevent.idtypeaction}" data-level="${listevent.idlevelaction}" data-from="${datefrom}"  data-to="${dateto}">
				<td>
					<span class="event-name"><c:out value="${listevent.advertname}"></c:out></span>
					<input type="hidden" value="${listevent.idtypeaction}">
					<input type="hidden" value="${listevent.idlevelaction}">
				</td>
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
				<td><button class="editadv" value="${listevent.id}" name="editevent">Редагувати зголошення</button><input type="hidden"  value="${listevent.id}" id="idedit"/></td>

				<td><button class="report" value="${listevent.id}">Заповнити звіт</button></td>
				<td class="customerIDCell">
					<div >
						<input type="hidden" value="${listevent.idstatusreport}"> <c:out value="${listevent.statusreport}"></c:out>
					</div>
					<div align="right">
						<button value="${listevent.idstatusreport}" class="recommendt">i</button>
					</div>

				</td>
				<td><img src="images/filepdf.png" alt="save"></td>
			</tr>
		</c:forEach>
		<tr class="no-results"><td colspan="12">За заданим пошуком немає результатів</td></tr>
		</tbody>
	</table>
	<div id="dialoginfcom" title="Інформація про коменданта"></div>
	<div id="dialoginfrecom" title="Інофрмація по зголошенню"></div>
	<div id="dialogeditadv" title="Редагування"></div>
	<div id="dialogreportadv" title="Створення"></div>

	<%@ include file = "footer.jsp" %>
</body>
</html>