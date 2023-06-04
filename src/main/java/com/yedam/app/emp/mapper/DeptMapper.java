package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public List<DeptVO> deptList(DeptVO vo);
	public int deptInsert(DeptVO vo);
	public DeptVO deptSelect(int deptId);
	public int deptUpdate(DeptVO vo);
	
	public List<Map<String, Object>> selectLocation();
}
