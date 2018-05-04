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
	<link rel="stylesheet" type="text/css" href="css/style_new.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<link rel="stylesheet" type="text/css" href="jquery-ui-1.12.1.custom/jquery-ui.css">
	<script type="text/javascript"></script>
	<script src="jquery/jquery-1.12.0.min.js"></script>
	<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	
</head>
<body>
<%@ include file = "header.jsp" %>
<!-- HEADER -->
	<!-- <div class="ui-widget-header ui-corner-top form_pad">
		<h1 align="center">Крайова булава УПЮ</h1>
		<h2 align="center">Список акцій</h2>
	</div>
	 -->
<!-- /HEADER -->
<!-- NAVIGATION -->
	<div>
		
	</div>
<!-- /NAVIGATION -->
<!-- MAIN SECTION -->
<main>
	<div>
		<h3 align="center">На електронну адресу скинуто код для редагування</h3>
		<h3 align="center">Дані збережено для перегляду перейдіть за посиланням <a href="listevents.html">Список зглошених акцій</a></h3>
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