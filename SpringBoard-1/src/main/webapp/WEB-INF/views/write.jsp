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
	<h3>WRITE�� ����!</h3>
	<form method="post" action="confirmWrite">

		<table width="650" border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td><b>�۹�ȣ</b></td>
				<td>�ڵ� ����<input type="hidden" name="id"></td>
			</tr>
			<tr>
				<td><b>����</b></td>
				<td><input type="text" name="title" size="70" maxlength="70"required></td>
			</tr>
			<tr>
				<td><b>����</b></td>
				<td><textarea name="content" class="contents" cols="72" rows="25" required></textarea>
				<input type="hidden" name="viewCnt" value="0"></td>
			</tr>
		</table>
		<table width="650">
			<tr>
				<td width="600"></td>
				<td><a href="./showList"><input type="button" value="���"></a></td>
				<td><input type="submit" value="�ۼ�"></td>
			</tr>
		</table>
	</form>
</body>
</html>