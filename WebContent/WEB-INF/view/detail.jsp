<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<title>프로젝트 상세보기</title>

</head>
<body>
	<header><h2>SPMS(Simple Project Management System)</h2></header>
	<section>
		<table>
			<tr>
				<th>프로젝트 일련번호</th><td>${projects.serialNo}</td>
			</tr>
			<tr>
				<th>프로젝트 이름</th><td>${projects.name}</td>
			</tr>
			<tr>
				<th>프로젝트 내용</th><td>${projects.content}</td>
			</tr>
			<tr>
				<th>프로젝트 시작날짜</th><td>${projects.startDate}</td>
			</tr>
			<tr>
				<th>프로젝트 종료날짜</th><td>${projects.endDate}</td>
			</tr>
			<tr>
				<th>프로젝트 진행상태</th><td>${projects.process}</td>
			</tr>
		</table>
		
		<a href="modify.do?no=${projects.serialNo}">[수정]</a>
		<a href="#" onClick="deleteBtn(); return false;">[삭제]</a>
		<script type="text/javascript">
			function deleteBtn(){
				if (confirm("정말 삭제하시겠습니까??") == true){    
					location.replace("delete.do?no=${projects.serialNo}");
				}else{   
			    	return false;
				}
			}
		</script>
		<a href="list.do">[돌아가기]</a>
	</section>
	<footer><h4>SPMSⓒ2016</h4></footer>
</body>
</html>