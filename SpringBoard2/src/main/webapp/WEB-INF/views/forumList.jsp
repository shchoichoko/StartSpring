<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="max-width: 1000px">
    <div class="py-5 text-center">
        <h2>�Խ���</h2>
    </div>

    <div class="row">
        <div class="col">
            <button  onclick="location.href='write.jsp'"
                    th:onclick="|location.href='@{/forum/goWrite}'|">�� ���</button>
        </div>
        <br>
    </div>

    <div>
        <table class="table">
            <thead>
            <tr style="text-align: center">
                <th>�۹�ȣ</th>
                <th>����</th>
                <th>�ۼ���</th>
                <th>�����</th>
                <th>��ȸ��</th>
            </tr>
            </thead>

            <tbody>

            <tr th:each="forum : ${forumList}">
                <td style="text-align: center" th:text="${forum.id}"></td>
                <td>
                    <a th:text="${forum.title}" th:href="@{/forum/showOneForum(id=${forum.id})}"></a>
                </td>
                <td style="text-align: center" th:text="${forum.writer}"></td>
                <td style="text-align: center" th:text="${forum.time}"></td>
                <td style="text-align: center" th:text="${forum.countView}"></td>
            </tr>

            </tbody>
        </table>
    </div><br>

    <!--  Pagination  -->

    <div id="pageNum" >

        <a th:href="@{/forum/forumList(page = ${ppPage - 1})}"> << </a>
        <a th:if="${pPage == 1}" th:href="@{/board/list(page = ${pPage - 1})}"> < </a>
        <a th:if="${pPage > pageSize}" th:href="@{/board/list(page = ${startPage}-10 -1)}"> < </a>
            <th:block th:each="page : ${#numbers.sequence(startPage, endPage)}">
                <!--    �����Ͱ� �ƿ� ���� ���� 1�� ǥ���ϵ��� �ϱ� ���ؼ�     -->
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
        <form th:action="@{/board/list}" method="get">
            <br><input type="text" name="searchKeyword">
            <button type="submit">�˻�</button>
        </form>
    </div>
</div>
</body>
</html>