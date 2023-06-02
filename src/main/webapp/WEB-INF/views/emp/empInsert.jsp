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
	<h3>사원등록</h3>
	<form action="empInsert" method="POST">
	
		<br> lName*<input name="lastName"> <br> 
		jobId*<select name="jobId">
			<option>선택</option>
			<c:forEach items="${jobs}" var="job" >
				<option value="${job.jobId}">${job.jobTitle}</option>
			</c:forEach>
		</select> <br> 
		departmentId<br>
		<c:forEach items="${depts}" var="dept" varStatus="index">
			<input type="radio" name="departmentId" value="${dept.departmentId}">${dept.departmentName}
		<c:choose>
		<c:when test="${(index.index+1)%3 == 0}"><br>
		</c:when>
		</c:choose>
		</c:forEach>
		<br> email*<input name="email"><br> 
		fName<input	name="firstName"><br>
		
		<button>저장</button>
	</form>
</body>
</html>