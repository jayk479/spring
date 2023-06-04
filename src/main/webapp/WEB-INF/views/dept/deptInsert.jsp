<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>부서등록</h3>
	<form action="deptInsert" method="post">
		departmentId<input name="departmentId" ><br>
		departmentName<input name="departmentName" ><br>
		location
		<select name="locationId">
		<option>location</option>
		<c:forEach items="${loca}" var="loca">
			<option value="${loca.locationId}">${loca.city}</option>
		</c:forEach>
		
		</select><br>
		managerId<input name="departmentName" ><br>
		<button>저장</button>
	</form>
</body>
</html>