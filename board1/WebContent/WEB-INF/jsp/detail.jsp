<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>	
	<a href="/list">리스트로 돌아가기</a>	
	<a href="/del?i_board=${detail.i_board}"><button>삭제</button></a>
	<a href="/update?i_board=${detail.i_board}"><button>수정</button></a>	
	<div>
		<div>번호 : ${detail.i_board}</div>
		<div>제목 : ${detail.title}</div>
		<div>내용 : ${detail.ctnt}</div>
	</div>
</body>
</html>