<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//setParameter는 없음
	//자료를 담고 다시 자료를 빼내기 위해서
	//내장객체 중 set, get Attribute가 있는 친구가 4개!
	//pageContext, request, session, application
	pageContext.setAttribute("name", "순일이"); //우선순위가 request보다 높다 1등
	request.setAttribute("name", "홍길동"); //2등
	session.setAttribute("name", "도흠이"); //3등
	application.setAttribute("name", "유정이"); //4등
	
	//el식으로 찍는것은 내장객체(1~ 4등)에 저장되어 있는 애들만 사용이 가능함 -> key값만 사용
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${param.n1} + ${param.n2} = ${param.n1 + param.n2}</div>
	<div>${name}</div>
</body>
</html>