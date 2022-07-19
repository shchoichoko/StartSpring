<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>WRITE에 왔음!</h3>
	<form method="post" action="confirmWrite">

		<table width="650" border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td><b>글번호</b></td>
				<td>자동 생성<input type="hidden" name="id"></td>
			</tr>
			<tr>
				<td><b>제목</b></td>
				<td><input type="text" name="title" size="70" maxlength="70"required></td>
			</tr>
			<tr>
				<td><b>내용</b></td>
				<td><textarea name="content" class="contents" cols="72" rows="25" required></textarea>
				<input type="hidden" name="viewCnt" value="0"></td>
			</tr>
		</table>
		<table width="650">
			<tr>
				<td width="600"></td>
				<td><a href="./showList"><input type="button" value="취소"></a></td>
				<td><input type="submit" value="작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>