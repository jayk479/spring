package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class DeptVO {
	int departmentId;
	String departmentName;
	int managerId;
	int locationId;
	String city;

	String[] getLocaIdArr() {
		return Integer.toString(locationId).split(",");
	}

}
