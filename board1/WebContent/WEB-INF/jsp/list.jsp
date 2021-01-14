<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.koreait.board.model.BoardEntity" %>
<%
	List<BoardEntity> list = (List)request.getAttribute("list"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>
		<a href="/write"><button>글쓰기</button></a>
	</div>
	<table>
		<tr>		
			<td>번호</td>
			<td>제목</td>
			<td>등록일시</td>
		</tr>
	<% for (BoardEntity vo : list) { %>
		<tr>		
			<td><%=vo.getI_board() %></td>
			<td><a href="/detail?i_board=<%=vo.getI_board()%>"><%=vo.getTitle() %></a></td>
			<td><%=vo.getR_dt() %></td>
		</tr>
	<% } %>
	</table>	
	<div>
	</div>
</body>
</html>