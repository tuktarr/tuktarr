<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!	//메소드 안에 있기 때문에 또 다른 메소드를 생성할 수 없다. !를 붙여줘서 전역으로 선언
	int a = 10;
	private int sum(int n1, int n2) {
		return n1 + n2;	
	}

%>
<%
	int a = 20;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><%=sum(10, 40) %></div>
	<div><%=this.a %></div>
	<div><%=a %></div>
</body>
</html>