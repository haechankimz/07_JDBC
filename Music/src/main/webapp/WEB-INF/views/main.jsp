<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>MUSIC</title>
</head>
<body>

  <h2>Music Playlist</h2>
  <hr>

  <form action="/music/add" method="GET">
    <h4>플레이 리스트 음악 추가</h4>
    <div>
      노래 제목 : <input type="text" name="musicName">
    </div>
  
    <div>
      가수 : <input type="text" name="artist">
    </div>

    <button>음악 추가</button>
  </form>

  <br>

  (노래 제목 클릭 시 삭제)

  <table border="1" style="border-collapse : collapse;">
    
    <thead>
      <th>번호</th>
      <th>노래 제목</th>
      <th>가수</th>
    </thead>

    <tbody>
      <c:forEach items="${musicList}" var="music">
        <tr>
          <td>${music.musicNo}</td>
          <td>
            <a href="/music/delete?musicNo=${music.musicNo}">${music.musicName}</a>
          </td>
          <td>${music.artist}</td>
        </tr>
      </c:forEach>

      <%-- DB 조회 결과를 이용해서 화면 출력 --%>

    </tbody>
  </table>

 <hr>

  <h4>Playlist 노래제목 검색</h4>
  <form action="/music/search" method="GET">
    <div>
      가수 이름 : <input type="text" name="artist" size="35">
    </div>
    <button>검색</button>
  </form>









  <c:if test="${not empty message}" >
    <script>
      alert("${message}");
    </script>

    <c:remove var="message"/>
  </c:if>
  
</body>
</html>