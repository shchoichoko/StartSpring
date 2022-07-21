<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="max-width: 1000px">
		<div class="py-5 text-center">
			<h2>게시판</h2>
		</div>

		<div class="row">
			<div class="col">
				<a href="/forum/goWrite"><button>글 등록</button></a>
			</div>
			<br>
		</div>

		<div>
			<!-- 
			<table class="table">
				<thead>
					<tr style="text-align: center">
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="forum" items="${forumList.content}">
						<tr>
							<td style="text-align: center">${forum.id}</td>
							<td><a href="/forum/showOneForum/${forum.id}">
									${forum.title} </a></td>
							<td style="text-align: center">${forum.author}</td>
							<td style="text-align: center">${forum.date}</td>
							<td style="text-align: center">${forum.countView}</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
			 -->
			<table class="table">
				<tr class="table-primary">
					<th width="10%"><b>번호</b></th>
					<th width="50%"><b>제목</b></th>
					<th width="10%"><b>조회수</b></th>
					<th width="30%"><b>등록일</b></th>
				</tr>
				<c:forEach var="forum" items="${PageDto.forum.content}">
					<tr class="table-active">
						<td>${forum.id}</td>
						<td class='align-left'><a
							href="/forum/showOneForum/${forum.id}"> ${forum.title}
						</a></td>
						<td>${forum.countView}</td>
						<td>${forum.date}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br>

		<!--Pagination     -->
		<c:choose>
			<c:when test="${keyword eq null || keyword eq ''}">
				<ul class="pagination">
					<c:set var="pagination" value="${PageDto.pagination}" />
					<c:if test="${pagination.ppPage != 0 && pagination.pPage != 0}">
						<li class="page-item"><a class="page-link"
							href='/forum/showForumList?cPage=${pagination.ppPage}'>&lt;&lt;</a></li>
						<li class="page-item"><a class="page-link"
							href='/forum/showForumList?cPage=${pagination.pPage}'>&lt;</a></li>
					</c:if>

					<c:forEach var="noPage" begin="${pagination.startPage}"
						end="${pagination.lastPage}">
						<c:if test="${noPage != 0}">
							<c:choose>
								<c:when test="${noPage == pagination.cPage}">
									<li class="page-item active"><a class="page-link"
										href='/forum/showForumList?cPage=${noPage}'>${noPage}</a></li>
								</c:when>
								<c:when test="${noPage != pagination.cPage}">
									<li class="page-item"><a class="page-link"
										href='/forum/showForumList?cPage=${noPage}'>${noPage}</a></li>
								</c:when>
							</c:choose>
						</c:if>
					</c:forEach>

					<c:if test="${pagination.nnPage != 0 && pagination.nPage != 0}">
						<li class="page-item"><a class="page-link"
							href='/forum/showForumList?cPage=${pagination.nPage}'>&gt;</a></li>
						<li class="page-item"><a class="page-link"
							href='/forum/showForumList?cPage=${pagination.nnPage}'>&gt;&gt;</a></li>
					</c:if>
				</ul>
			</c:when>

			<c:otherwise>
				<ul class="pagination">
					<c:set var="pagination" value="${PageDto.pagination}" />
					<c:if test="${pagination.ppPage != 0 && pagination.pPage != 0}">
						<li class="page-item"><a class="page-link"
							href='/forum/showForumList?cPage=${pagination.ppPage}&keyword=${keyword}'>&lt;&lt;</a>
						</li>
						<li class="page-item"><a class="page-link"
							href='/forum/showForumList?cPage=${pagination.pPage}&keyword=${keyword}'>&lt;</a>
						</li>
					</c:if>

					<c:forEach var="noPage" begin="${pagination.startPage}"
						end="${pagination.lastPage}">
						<c:if test="${noPage != 0}">
							<c:choose>
								<c:when test="${noPage == pagination.cPage}">
									<li class="page-item active"><a class="page-link"
										href='/forum/showForumList?cPage=${noPage}&keyword=${keyword}'>${noPage}</a>
									</li>
								</c:when>
								<c:when test="${noPage != pagination.cPage}">
									<li class="page-item"><a class="page-link"
										href='/forum/showForumList?cPage=${noPage}&keyword=${keyword}'>${noPage}</a>
									</li>
								</c:when>
							</c:choose>
						</c:if>
					</c:forEach>

					<c:if test="${pagination.nnPage != 0 && pagination.nPage != 0}">
						<li class="page-item"><a class="page-link"
							href='/forum/showForumList?cPage=${pagination.nPage}&keyword=${keyword}'>&gt;</a>
						</li>
						<li class="page-item"><a class="page-link"
							href='/forum/showForumList?cPage=${pagination.nnPage}&keyword=${keyword}'>&gt;&gt;</a>
						</li>
					</c:if>
				</ul>
			</c:otherwise>
		</c:choose>

		<form class="d-flex" action="/forum/showForumList" method="get">
			<input class="form-control me-sm-2" type="text" name="keyword" placeholder="Search">
			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
		</form>

	</div>
</body>
</html>