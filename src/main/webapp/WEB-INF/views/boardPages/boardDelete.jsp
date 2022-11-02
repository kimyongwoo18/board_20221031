<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오전 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardDelte</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <style>
    #a{
     width: 800px;
      margin-top: 50px;
    }
  </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
  <div class="container" id="a">
    <form action="/board/delete" name = "deleteForm" method="post">
      비밀번호: <input type="password" id="inputPass" name="inputPass">
      <input type="text" name="id" value="${board.id}" hidden>
      <input type="button" class="brn btn-dark" onclick="deleteFn()" value="삭제">
    </form>
  </div>
  <script>
    const deleteFn = () => {

             if(document.getElementById("inputPass").value != ${board.boardPass}){

        alert("비밀번호가 일치하지않습니다.")
        return false;

      }else if(document.getElementById("inputPass").value == ${board.boardPass}){
        document.deleteForm.submit();
      }

    }
  </script>
</body>
</html>
