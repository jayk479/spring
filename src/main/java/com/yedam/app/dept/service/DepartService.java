package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DepartService {
	
	// 전체조회
	public List<DepartVO> getAllDept();
		
	// 단건조회
	public DepartVO getDeptInfo(DepartVO vo);
	
	// 등록
	public int insertDeptInfo(DepartVO vo);
	
	// 수정
	public Map<String, Object> updateDeptList(List<DepartVO> vo);
	
	// 삭제
	public int deleteDeptList(List<DepartVO> vo);

}
