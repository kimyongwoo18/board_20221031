<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardDetail</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #detail {
            width : 800px;
            margin-top: 50px;
        }
        th {
            width:100px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="detail">

    <table class="table table-striped">
        <tr>
            <th>글번호</th>
            <td>${board.id}</td>
        </tr>
        <tr>

            <th>제목</th>
            <td>${board.boardTitle}</td>
        </tr>
        <tr>

            <th>작성자</th>
            <td>${board.boardWriter}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${board.boardContents}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${board.boardHits}</td>
        </tr>
        <tr>
            <th>작성시간</th>
            <td>${board.boardCreatedDate}</td>
        </tr>
    </table>
    <button class="btn btn-primary" onclick="listFn()">목록</button>
    <button class="btn btn-warning" onclick="updateFn('${board.id}')">수정</button>
    <button class="btn btn-danger" onclick="deleteFn('${board.id}')">삭제</button>
    </div>
</body>
<script>
    const listFn = () => {
      location.href="/board/";
    }
    const updateFn = (id) => {
        location.href="/board/update?id="+id;
    }
    const deleteFn = (id) => {
        location.href="/board/delete?id="+id;
    }
</script>
</html>
