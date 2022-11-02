<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오전 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>boardSave</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <style>
    #save-form {
      width : 800px;
      margin-bottom: 100px;
    }
    #boardTitle {
      width : 100%;
    }
    #boardWriter {
      width : 100%;
    }
    #boardPass {
      width : 100%;
    }



  </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="save-form">
  <form action="/board/save" name="saveForm" method="post">
    <input type="text" name="boardTitle" id="boardTitle" placeholder="글제목"  class="form-control mb-1">
    <input type="text" name="boardWriter" id="boardWriter" placeholder="작성자" class="form-control mb-1">
    <input type="password" name="boardPass" id="boardPass" placeholder="비밀번호" class="form-control mb-1">
    <textarea name="boardContents" id="boardContents" cols="30" rows="10" placeholder="내용을 입력하세요" class="form-control mb-2"></textarea>
    <input type="button" value="작성완료" onclick="save()" class="btn btn-primary">

  </form>
</div>
</body>
<script>
  const save = () => {
    //글 제목, 작성자, 비밀번호, 글내용이 없으면 alert로 ~~를 입력하세요 출력하고
    //모든 내용이 작성되어 있으면 제출
    if(document.getElementById("boardTitle").value.length==0){
      alert("글제목 입력하세요");
      return false;
    }else if(document.getElementById("boardWriter").value.length==0){
      alert("작성자 입력하세요");
      return false;
    }else if(document.getElementById("boardPass").value.length==0){
      alert("비밀번호 입력하세요");
      return false;
    }else if(document.getElementById("boardContents").value.length==0){
      alert("내용 입력하세요");
      return false;
    }else {
      document.saveForm.submit();
    }
  }
</script>
</html>
