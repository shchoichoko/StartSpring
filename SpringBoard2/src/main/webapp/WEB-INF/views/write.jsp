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

    <form action="/board/writepro" method="post" enctype="multipart/form-data">


        <div>
            <label>����</label>
            <input name="title" type="text" class="form-control" placeholder="������ �Է��ϼ���.">

        </div>
        <div>
            <label>�ۼ���</label>
            <input name="writer" type="text" class="form-control" placeholder="�ۼ��ڸ� �Է��ϼ���.">
        </div>
        <div>
            <label>����</label>
            <textarea cols="150" rows="10" id="contents" name="content" class="form-control" placeholder="������ �Է��ϼ���."></textarea>

        </div>

        <hr class="my-4">

        <div class="row">
            <div class="col">
                <input class="w-100 btn btn-primary btn-lg" type="file" name="file" vaule="���ϼ���">
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg" type="submit">�ۼ�</button>
            </div>
        </div>

    </form>

</div>
</body>
</html>