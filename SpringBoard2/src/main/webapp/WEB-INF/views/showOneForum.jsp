<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div class="py-5 text-center">
			<h2>게시글 상세</h2>
		</div>

		<br> <br>
		<form method="post" action="#">
			<table cellspacing=1 width=650 border="1" class="table">
				<tr>
					<td style="text-align: center;"><b>글번호</b></td>
					<td>${forum.id}</td>
				</tr>
				<tr>
					<td style="text-align: center;"><b>제목</b></td>
					<td>${forum.title}</td>
				</tr>
				<tr>
					<td style="text-align: center;"><b>날짜</b></td>
					<td>${forum.date}</td>
				</tr>
				<tr>
					<td style="text-align: center;"><b>작성자</b></td>
					<td>${forum.author}</td>
				</tr>
				<tr>
					<td style="text-align: center;"><b>Hits</b></td>
					<td>${forum.countView}</td>
				</tr>
				<tr>
					<td style="text-align: center;"><b>내용</b></td>
					<td style="height: 250px;"><textarea
							style="width: 98%; height: 90%;">${forum.content}</textarea></td>
				</tr>
				<tr>
			</table>
			<table width="650">
				<tr>
					<td width="630"></td>
					<td><a href="/forum/showForumList"><input type="button" value="목록"></a></td>
					<td><a href="/forum/modify/${forum.id}"><input type="button" value="수정하기"></a></td>
					<td><a href="/forum/delete/${forum.id}"><input type="button" value="삭제하기"></a></td>
				</tr>
			</table>
		</form>
		<hr class="my-4">
		<h2>Comments</h2>

		<!-- Comments Form -->
		<div class="card my-4">
			<h5 class="card-header">Leave a Comment:</h5>
			<div class="card-body">
				<form name="comment-form" id="reply" action="/replyWrite" method="post" autocomplete="off">
					<div class="form-group">
						<input cols="80" rows="10" type="text" id="content" name="content" class="form-control" placeholder="댓글을 입력해주세요.." aria-label="댓글을 입력해주세요..">
						<input style="width: 10px" type="hidden" id="id" name="id" value="${forum.id}">
					</div>
					<br>
					<button class="btn btn-outline-secondary" type="submit">등록</button>
				</form>
				<a href="/replyDelete/${forum.id}"><input type="button" value="댓글삭제"></a>
				
				<%-- <form id="reply" action="/replyDelete/${forum.id}" method="post">
					<input style="width: 10px" type="hidden" id="id" name="id" value="${boardReply.replyId}">
					<button class="btn btn-outline-secondary" type="submit">삭제</button>
				</form> --%>
			</div>
		</div>

		<!--  댓글이 append되도록 한다.  -->
		<table class="table">
			<thead>
				<tr style="text-align: center">
					<th>작성자</th>
					<th>댓글내용</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="replyList" items="${boardReplyList}">
					<tr>
						<td style="text-align: center">${replyList.author}</td>
						<td style="text-align: center">${replyList.content}</td>
						<td style="text-align: center">${replyList.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>