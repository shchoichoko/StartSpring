<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� �ۼ� ������</title>
</head>
<body>
<h3>�� �ۼ� �������Դϴ�.</h3>
<div class="container">

    <div class="py-5 text-center">
        <h2>�� ���</h2>
    </div>

    <form action="/forum/confirmWrite" method="post" enctype="multipart/form-data">


        <div>
            <label>����</label>
            <input name="title" type="text" class="form-control" placeholder="������ �Է��ϼ���.">

        </div>
        <div>
            <label>�ۼ���</label>
            <input name="author" type="text" class="form-control" placeholder="�ۼ��ڸ� �Է��ϼ���.">
        </div>
        <div>
            <label>����</label>
            <textarea cols="150" rows="10" id="contents" name="content" class="form-control" placeholder="������ �Է��ϼ���."></textarea>
        </div>
        <input type="hidden" value=0>
        <hr class="my-4">

        <div class="row">
            <div class="col">
                <button type="submit">�ۼ�</button>
            </div>
        </div>

    </form>

</div>
</body>
</html>