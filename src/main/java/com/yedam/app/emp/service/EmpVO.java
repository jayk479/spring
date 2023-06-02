package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String hireDate;
	String jobId;
	String email;
	String departmentId;
	String orderColumn;
	
	String[] getDeptArr() {
		return departmentId.split(",");
		//체크박스에서 체크해서 한꺼번에 삭제할 떄 사용 가능ㅇ
	}
}
