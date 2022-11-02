<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>boardList</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #list {
            width : 1000px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="list">
    <table class="table table-striped table-hover text-center">
       <tr>
        <th>글번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>조회수</th>
        <th>작성시간</th>
       </tr>
<c:forEach items="${boardList}" var="board">
        <tr>
            <td>
            ${board.id}
            </td>
            <td>
            ${board.boardWriter}
            </td>
            <td>
                <a href="/board?id=${board.id}">${board.boardTitle}</a>
            </td>
            <td>
            ${board.boardHits}
            </td>
            <td>
                <fmt:formatDate value="${board.boardCreatedDate}" pattern="yyyy-mm-dd hh:mm:ss"></fmt:formatDate>
            </td>
        </tr>
</c:forEach>
    </table>
        <button class="brn btn-dark" onclick="index()">초기화면</button>
</div>


</body>
<script>
    // const boardHits = (clickedId) =>{
    //
    //     location.href="/uphits?id="+clickedId;
    //
    //
    //     location.href="/board?id="+clickedId;
    //
    // }
    const index = () => {
      location.href="/";
    }

</script>
</html>
