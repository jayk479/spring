<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>전체부서정보</title>
</head>

<body>
	<div>
		<h3>부서조회</h3>
		<a href="deptInsert">등록</a>
		<button type="button" id="checkDel">선택삭제</button>
		<table border="1">
			<thead>
				<tr>
					<th><input type="checkbox"></th>
					<th>부서번호</th>
					<th>부서이름</th>
					<th>매니저번호</th>
					<th>지역번호</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${deptList}" var="dept">
					<tr onclick="findDeptInfo(event, ${dept.departmentId})">
						<td><input type="checkbox"></td>
						<td>${dept.departmentId}</td>
						<td>${dept.departmentName}</td>
						<td>${dept.managerId}</td>
						<td>${dept.locationId}</td>
						<td><button type="button">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form name="del" action="deptDelete" method="post">
		</form>
		</div>
		<script>
			let result = "${departmentId}";
			if (result != "") {
				alert(result);
			}
			
			let delBtnList = Array.from(document.getElementsByTagName('button')).filter(item => item.id != "checkDel")
			
			delBtnList.forEach(el => {
				el.addEventListener('click', function(e){
					let tdList = this.parentElement.parentElement.children;
					let deptNo = tdList[1].textContent;

					deleteDeptInfo(0, deptNo);
					del.submit();
				})
			})
			
			document.getElementById('checkDel').addEventListener('click', function(e){
				let checked = document.querySelectorAll('input[type="checkbox"]:checked');
				for(let i=0; i < checked.length; i++){
					let deptNo = checked[i].parentElement.nextElementSibling.textContent;
					deleteDeptInfo(i, deptNo);
				}
				del.submit();
			})
			
			function deleteDeptInfo(index, deptNo) {
				let inputTag = document.createElement('input');
				inputTag.type = 'hidden';
				inputTag.name = 'deptList[' + index + '].departmentId';
				//list명[index].필드명
				inputTag.value = deptNo;

				let formTag = document.getElementsByName('del')[0];
				formTag.append(inputTag);
			}

			function findDeptInfo(event, deptNo){
				if(event.target.tagName != 'INPUT' && event.target.tagName != 'BUTTON'){
					location.href = "deptInfo?departmentId="+deptNo;
				}

				// event.target // 실제 이벤트가 발생한 태그
				// event.currentTarget 
				// // this 와 같은 의미 -> 지금 해당 이벤트에 대해 동작을 하는 태그
				// // event.target 은 고정값
				// // event.currentTarget 부모부모 전파됨ㅇㅇ
				// event.prventDefault(); 
				// // 기본으로 등록 된 이벤트 동작을 막음. 
				// event.stopPropagation();
				// // 이벤트 버블링(전파)를 막음

			}	

			// function delDept(deptNo){
			// 	let delTr=document.getElementById('delBtn').parentElement;
			// 	console.log(delTr);
			// 	//delTr.remove();
			// }
			
			// document.getElementById('delBtn').addEventListener('click', function(e){
			// 	let clickBtn = document.querySelector('')
			// 	for(let i=0; i < checked.length; i++){
			// 		let deptNo = checked[i].parentElement.nextElementSibling.textContent;
			// 		deleteDeptInfo(i, deptNo);
			// 	}
			// 	del.submit();
			// })

		</script>
	
</body>

</html>