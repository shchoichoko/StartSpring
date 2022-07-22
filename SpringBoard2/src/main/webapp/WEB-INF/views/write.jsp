<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
            <input name="title" type="text" class="form-control" placeholder="제목을 입력하세요." required>

        </div>
        <div>
            <label>작성자</label>
            <input name="author" type="text" class="form-control" placeholder="작성자를 입력하세요." required>
        </div>
        <div>
            <label>내용</label>
            <textarea cols="150" rows="10" id="contents" name="content" class="form-control" placeholder="내용을 입력하세요." required></textarea>
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