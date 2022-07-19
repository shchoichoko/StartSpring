<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="#">
		<table cellspacing=1 width=650 border="1" class="table">
			<tr>
				<td style="text-align: center;"><b>글번호</b></td>
				<td>${boardItem.no}</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>제목</b></td>
				<td>${boardItem.title}</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>날짜</b></td>
				<td>차후구현</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>작성자</b></td>
				<td>${boardItem.name}</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>Hits</b></td>
				<td>차후구현</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>내용</b></td>
				<td style="height: 250px;">
				<textarea style="width: 98%; height: 90%;">${boardItem.content}</textarea></td>
			</tr>
			<tr>
		</table>
		<center>
			<table width="650">
				<tr>
					<td width="630"></td>
					<td><input type="button" value="목록">
					</td>
					<td><input type="button" value="수정하기"></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>