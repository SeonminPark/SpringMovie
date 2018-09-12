<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <spring:url value="/resources/css/banner.png" var="bannerImg"/> --%>

<title>Insert title here</title>
<link rel="stylesheet" href="/css/movie.css" />
<script>
 	window.onload = function(){	
		$('.menusSpan').click( function(){
			location.href="/Movie/Reservation?menu_name=" + $(this).html();
		}); 

	}
</script>
</head>
<body>
	<div id="wrap">
		<div id="top"><%@ include file="../include/top.jspf" %></div>
		<div id="banner"><%@ include file="../include/banner.jspf" %></div>
		<div id="menu"><%@ include file="../include/menu.jspf" %></div>
		<div id="main"><%@ include file="../include/main.jspf" %></div>
		<div id="bottom"><%@ include file="../include/bottom.jspf" %></div>
	</div>
</body>
</html>