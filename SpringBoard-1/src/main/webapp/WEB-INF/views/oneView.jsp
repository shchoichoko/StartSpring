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
				<td style="text-align: center;"><b>�۹�ȣ</b></td>
				<td>${boardItem.no}</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>����</b></td>
				<td>${boardItem.title}</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>��¥</b></td>
				<td>���ı���</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>�ۼ���</b></td>
				<td>${boardItem.name}</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>Hits</b></td>
				<td>���ı���</td>
			</tr>
			<tr>
				<td style="text-align: center;"><b>����</b></td>
				<td style="height: 250px;">
				<textarea style="width: 98%; height: 90%;">${boardItem.content}</textarea></td>
			</tr>
			<tr>
		</table>
		<center>
			<table width="650">
				<tr>
					<td width="630"></td>
					<td><input type="button" value="���">
					</td>
					<td><input type="button" value="�����ϱ�"></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>