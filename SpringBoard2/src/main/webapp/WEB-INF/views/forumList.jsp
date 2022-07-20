<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <td>
                    <a href="/forum/showOneForum/${forum.id}"> ${forum.title} </a>
                </td>
                <td style="text-align: center">${forum.author}</td>
                <td style="text-align: center">${forum.date}</td>
                <td style="text-align: center">${forum.countView}</td>
            </tr>
           	</c:forEach>


            </tbody>
        </table>
    </div><br>

    <!--  Pagination    
    <div id="pageNum" >

        <a c:href="@{/forum/forumList(page = ${ppPage - 1})}"> << </a>
        <a c:if="${pPage == 1}" th:href="@{/board/list(page = ${pPage - 1})}"> < </a>
        <a c:if="${pPage > pageSize}" th:href="@{/board/list(page = ${startPage}-10 -1)}"> < </a>
            <th:block th:each="page : ${numbers.sequence(startPage, endPage)}">
                 데이터가 아예 없을 때는 1만 표시하도록 하기 위해서    
                <a th:if="${page == 0}" th:href="@{/board/list(page = ${page - 1})}" ></a>
                <a th:if="${page != 0 && page != nowPage}" th:href="@{/board/list(page = ${page - 1})}" th:text="${page}"></a>
                <strong th:if="${page == nowPage}" th:text="${page}" style="color : red"></strong>
            </th:block>

        <a th:if="${endPage < nnPage}" th:href="@{/board/list(page = ${startPage}+10 -1)}"> > </a>
        <a th:if="${endPage == nnPage}" th:href="@{/board/list(page = ${nnPage - 1})}"> > </a>
        <a th:href="@{/board/list(page = ${nnPage - 1})}"> >> </a>

        <br>
    </div>

    
    <div id="searchBlock">
        <form action="@{/showForumList}" method="post">
            <br><input type="text" name="searchKeyword">
            <button type="submit">검색</button>
        </form>
    </div>
      -->
</div>
</body>
</html>