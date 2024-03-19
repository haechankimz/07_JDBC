<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${music.musicName}삭제페이지</title>
</head>
<body>

  <h3>${music.musicName} 삭제</h3>

  <form action="/music/delete" method="GET">
  
    <table>
      <tr>
        <th>번호</th>
        <td>${music.musicNo}</td>
      </tr>

      <tr>
        <th>노래 제목</th>
        <td>${music.musicName}</td>
      </tr>
    
      <tr>
        <th>가수</th>
        <td>${music.artist}</td>
      </tr>
    
      <tr>
        <th>등록날짜</th>
        <td>${music.comDate}</td>
      </tr>

      <button id="deleteBtn" data-music-no="${music.musicNo}">삭제</button>
    </table>


  </form>

  <script src="/resources/JS/delete.js"></script>

  <c:if test="${not empty message}" >
    <script>
      alert("${message}");
    </script>

    <c:remove var="message"/>
  </c:if>
  


</body>
</html>