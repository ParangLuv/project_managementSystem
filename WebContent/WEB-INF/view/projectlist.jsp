<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<style>

</style>
<title>프로젝트 리스트</title>
</head>
<body>
	<header><h2>SPMS(Simple Project Management System)</h2></header>
	<section>
		<a href="add.do">새 프로젝트 등록</a>
	
		<c:if test="${projects.size() == 0}">
			<h1>등록된 프로젝트가 없습니다. 새 프로젝트를 등록해보세요!</h1>
		</c:if>	
		
		<c:if test="${projects.size() > 0 }">
			<table border="1">
				<tr>
					<th>등록번호</th>
					<th>프로젝트 이름</th>
					<th>시작날짜</th>
					<th>종료날짜</th>
					<th>상태</th>
				</tr>
			<c:forEach var="projects" items="${projects}">
				<tr>
					<td>${projects.serialNo}</td>
					<td><a href="detail.do?no=${projects.serialNo}">${projects.name}</a></td>
					<td>${projects.startDate}</td>
					<td>${projects.endDate}</td>
					<td>${projects.process}</td>
				</tr>
			</c:forEach>
			</table>		
		</c:if>
	</section>
	<footer><h4>SPMSⓒ2016</h4></footer>
</body>
</html>