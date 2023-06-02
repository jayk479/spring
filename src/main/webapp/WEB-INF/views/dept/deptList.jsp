<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept</title>
</head>
<body>
<h2>search</h2>
<form>
departmentName : <input type="text" name="departmentName">
locationId : <input name="locationId">
<button>search</button>
</form>
<h2>deptList</h2>
<table border="1">
	<thead>
	<tr>
	<th>departmentId</th>
	<th>departmentName</th>
	<th>managerId</th>
	<th>locationId</th>
	</tr>
	<thead>
	<tbody>
		<c:forEach items="${deptList}" var="dept">
			<tr>
			<td>${dept.departmentId}</td>
			<td>${dept.departmentName}</td>
			<td>${dept.managerId}</td>
			<td>${dept.locationId}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>