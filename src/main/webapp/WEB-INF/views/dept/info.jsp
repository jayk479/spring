<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서정보</title>
</head>
<body>
	<h3>부서수정</h3>
	<form onsubmit="return false" name="frm">
	<!-- submit막음 -->
		<div>
			<div>
				<label for="id">부서번호</label><input type="number" id="id"
					name="departmentId" readonly="readonly"
					value="${deptInfo.departmentId}"><br>
			</div>
			<div>
				<label for="name">부서이름</label><input type="text" id="name"
					name="departmentName" value="${deptInfo.departmentName}"><br>
			</div>
			<div>
				<label for="mId">매니저번호</label> <input type="number" id="mId"
					name="managerId" value="${deptInfo.managerId}">
			</div>
			<div>
				<label for="lId">지역번호</label> <input type="number" id="lId"
					name="locationId" value="${deptInfo.locationId}">
			</div>
			<button type="submit">수정</button>
			<button type="button">목록</button>
		</div>
	</form>
	<script>
	/* let result = "${updateRes}";
	if(result != "" && result != null){
		result = JSON.parse(result);
		let msg = `결과 : ${result.result} \n 
				   성공 : ${result.success} \n
				   대상 : ${result.deptList[0]}`;
		alert(msg);
	} */
	
		document.querySelector('button[type="submit"]').addEventListener('click', function(e){
			let data = [{
				'departmentId' : frm.departmentId.value,
				'departmentName' : frm.departmentName.value,
				'managerId' : frm.managerId.value,
				'locationId' : frm.locationId.value
			}]
			fetch('deptUpdate', {
				method : 'POST',
				headers : {
					'content-type' : 'application/json'
				},
				body : JSON.stringify(data)
			})
			//.then(response => console.log(response.body))
			//.then(response => window.location.href=response.url)
			//.then(response => document.body.innerHTML = response.text())
			//.then(response => response.json())
			.then(response => response.text())
			.then(data => console.log(data))
/* 			.then(result => {
				if(result != "" && result != null){
					let msg = `결과 : ${result.result} \n 
							   성공 : ${result.success} \n
							   대상 : ${result.deptList[0]}`;
					alert(msg);
				}
			}) */
			.catch(err => console.log(err))
		})
	</script>
</body>
</html>