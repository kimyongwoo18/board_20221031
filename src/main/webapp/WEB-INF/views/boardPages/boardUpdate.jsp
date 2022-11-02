<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오후 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardUpdate</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #a {
            width : 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container-fluid" id="a">
<h2 class="text-center">수정하세요</h2>
<form action="/board/update" method="post" name="updateForm" class="text-center">
    <input type="text" name="id" value="${board.id}" hidden>
<%--    이렇게 type에 hidden을 넣는 방법도 있다. <input type="hidden" name="id" value="${board.id}" >   --%>
    제목 : <input type="text" name="boardTitle" value="${board.boardTitle}" class="form-control"><br>
    내용 : <textarea name="boardContents" id="boardContents" cols="30" rows="10" class="form-control" >${board.boardContents}</textarea><br>
    <button  class="brn btn-dark">수정</button>


</form>
</div>
</body>
</html>
