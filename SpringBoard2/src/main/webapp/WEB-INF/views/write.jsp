<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 작성 페이지</title>
</head>
<body>
<h3>글 작성 페이지입니다.</h3>
<div class="container">

    <div class="py-5 text-center">
        <h2>글 등록</h2>
    </div>

    <form action="/forum/confirmWrite" method="post" enctype="multipart/form-data">


        <div>
            <label>제목</label>
            <input name="title" type="text" class="form-control" placeholder="제목을 입력하세요.">

        </div>
        <div>
            <label>작성자</label>
            <input name="author" type="text" class="form-control" placeholder="작성자를 입력하세요.">
        </div>
        <div>
            <label>내용</label>
            <textarea cols="150" rows="10" id="contents" name="content" class="form-control" placeholder="내용을 입력하세요."></textarea>
        </div>
        <input type="hidden" value=0>
        <hr class="my-4">

        <div class="row">
            <div class="col">
                <button type="submit">작성</button>
            </div>
        </div>

    </form>

</div>
</body>
</html>