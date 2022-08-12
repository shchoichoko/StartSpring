<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>글 수정 페이지</title>
</head>
<body>
<div class="container">

    <div class="py-5 text-center">
        <h2>글 수정</h2>
    </div>

    <form action="/forum/update/${forumModify.id}" method="post" enctype="multipart/form-data">


        <div>
            <label>제목</label>
            <input name="title" type="text" class="form-control" value="${forumModify.title}">

        </div>
        <div>
            <label>작성자</label>
            <input name="author" type="text" class="form-control" value="${forumModify.author}" readonly>
        </div>
        <div>
            <label>내용</label>
            <textarea cols="150" rows="10" id="contents" name="content" class="form-control" value="${forumModify.content}"></textarea>
        </div>
        <input type="hidden" value=0>
        <hr class="my-4">

        <div class="row">
            <div class="col">
                <button type="submit">수정완료</button>
            </div>
        </div>

    </form>

</div>
</body>
</html>