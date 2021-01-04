<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//http://localhost:9080/scriptlet_3.jsp?n1=10&n2=20
	String strN1 = request.getParameter("n1");
	String strN2 = request.getParameter("n2"); //내장객체
	
	int n1 = Integer.parseInt(strN1);
	int n2 = Integer.parseInt(strN2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무엇을 보고 있나?</title>
</head>
<body>
	<div><%=strN1 %> + <%=strN2 %> = <%=n1+n2 %></div>
</body>
</html>