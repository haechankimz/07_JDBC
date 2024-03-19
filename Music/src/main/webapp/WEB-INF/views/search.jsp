<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>검색 페이지</title>
</head>
<body>
  <h1>${param.artist} 검색 결과</h1>

	<%-- empty : 비어있거나 null인 경우 true 반환 --%>
	<c:if test="${empty musicList}">
		<h3>검색 결과가 없습니다</h3>
	</c:if>

	<%-- not empty : 비어 있지 않거나 null이 아닌 경우 true --%>
	<c:if test="${not empty musicList}">
	
		<table border="1">
			<thead>
				<tr>
					<th>노래 제목</th>
					<th>가수</th>
				</tr>
			</thead>
		
		<tbody>
				<c:forEach items="${musicList}" var="music">
					<tr>
						<%-- vs.count : 현재 반복 횟수 (1부터 시작) --%>
						<td>${music.musicName}</td>
						<td>${music.artist}</td>
					</tr>
				</c:forEach>
			
			</tbody>
		
		</table>
	</c:if>

  
</body>
</html>