package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DepartVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	
	//마이바티스 db에서 두 개의 단어를 언더바로 연결 할 때
	// 대문자로 다른 단어임을 표시해준다

}
