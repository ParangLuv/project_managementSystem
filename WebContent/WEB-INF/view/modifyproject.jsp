<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<title>프로젝트 수정</title>
</head>
<body>
<header><h2>SPMS(Simple Project Management System)</h2></header>
<section>
	<form action="modify.do?no=${projects.serialNo}" method="post">
		<fieldset>
			<legend>프로젝트 수정</legend>
			<p><input type="text" name="name" placeholder="프로젝트 이름" value="${projects.name}"></p>
			<p><textarea name="content" placeholder="프로젝트 내용" rows="20" cols="40">${projects.content}</textarea></p>
			<p><label for="startDate">시작날짜</label><input type="date" name="startDate" id="startDate" value="${projects.startDate}"></p>
			<p><label for="endDate">마감날짜</label><input type="date" name="endDate" id="endDate"  value="${projects.endDate}"></p>
			<p><select name="process">
				<option>-- 진행상태 --</option>
				<option value="준비" <c:if test="${projects.process eq '준비'}">selected="selected"</c:if>>준비</option>
				<option value="진행중" <c:if test="${projects.process eq '진행중'}">selected="selected"</c:if>>진행중</option>
				<option value="종료" <c:if test="${projects.process eq '종료'}">selected="selected"</c:if>>종료</option>
				<option value="보류" <c:if test="${projects.process eq '보류'}">selected="selected"</c:if>>보류</option>
			</select></p>
			<p><input type="submit" value="수정"><input type="button" value="취소" onclick="abort();"></p>
			<script>
				function abort(){
					history.back();
				}
			</script>
		</fieldset>
	</form>
</section>
<footer><h4>SPMSⓒ2016</h4></footer>

</body>
</html>