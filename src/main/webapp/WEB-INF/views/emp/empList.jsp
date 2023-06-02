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
	<h2>사원조회</h2>
	<a href="empInsert">등록</a>
	<!-- 등록페이지로 이동하는 거임ㅇㅇ -->
	<form action="empList">
		departmentId : <input name="departmentId" value="${emp.departmentId}">
		fName : <input name="firstName" value="${emp.firstName}">
		<button>검색</button>
		<!-- reset버튼만들기 -->
		<button type="reset">초기화</button>
	</form>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>employeeId</th>
				<th>name</th>
				<th>hireDate</th>
				<th>jobId</th>
				<th>departmentId</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td>${emp.employeeId}</td>
					<td>${emp.firstName}-${emp.lastName}</td>
					<td>${emp.hireDate}</td>
					<td>${emp.jobId}</td>
					<td>${emp.departmentId}</td>
					<td><a href="updateEmp?empId=${emp.employeeId}"><button>수정</button></a></td>
					<td><a href="deleteEmp?empId=${emp.employeeId}"><button>삭제</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>