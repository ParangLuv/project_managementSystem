<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<title>프로젝트 추가페이지</title>
</head>
<body>
<header><h2>SPMS(Simple Project Management System)</h2></header>
<section>
	<form action="add.do" method="post">
		<fieldset>
			<legend>새 프로젝트 등록</legend>
			<p><input type="text" name="name" placeholder="프로젝트 이름"></p>
			<p><textarea name="content" placeholder="프로젝트 내용" rows="20" cols="70"></textarea></p>
			<p><label for="startDate">시작날짜</label><input type="date" name="startDate" id="startDate"></p>
			<p><label for="endDate">마감날짜</label><input type="date" name="endDate" id="endDate" ></p>
			<p><select name="process">
				<option>-- 진행상태 --</option>
				<option value="준비">준비</option>
				<option value="진행중">진행중</option>
				<option value="종료">종료</option>
				<option value="보류">보류</option>
			</select></p>
			<p><input type="submit" value="저장"><input type="button" value="취소" onclick="abort();"></p>
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