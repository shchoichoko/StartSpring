<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a {
	text-decoration: none;
}

td {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">목록</h1>
	<table cellpadding="0" cellspacing="0" border="1" width="350"
		align="center">
		<tr>
			<td width="60">글번호</td>
			<td width="140">제목</td>
			<td width="100">작성자</td>
		</tr>
		<c:forEach var="boardItem" items="${boardItems}">
			<tr>
				<td>${boardItem.id}</td>
				<td><a href="./oneView?id=${boardItem.id}">${boardItem.title}</a></td>
				<td>${boardItem.name}</td>
			</tr>
		</c:forEach>
	</table>
	<table align="center">
		<tr>
			<td width="302">
			<td>
			<td><a href="./write"><input type="button" value="신규"></a></td>
		</tr>
	</table>
</body>
</html>