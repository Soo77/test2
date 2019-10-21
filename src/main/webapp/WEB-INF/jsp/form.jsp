<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add" method="post">
<%
request.setCharacterEncoding("utf-8");
%>
  <textarea name="ta" rows="10" cols="60"></textarea><br>
  <button>글쓰기</button>
</form>

</body>
</html>