package com.yedam.app.dept.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DepartMapper;
import com.yedam.app.dept.service.DepartService;
import com.yedam.app.dept.service.DepartVO;
import com.yedam.app.emp.mapper.EmpMapper;

@Service 
//impl로 끝나는 모든 클래스는 해당 어노테이션 존재해야함ㅇㅇ
public class DepartServiceImpl implements DepartService{
	
	@Autowired
	DepartMapper departMapper;
	
	@Autowired // 필요한 필드만큼 개별로 붙어야 됨ㅇㅇ
	EmpMapper empMapper;

	
	@Override
	public List<DepartVO> getAllDept() {
		return departMapper.selectAllDept();
	}

	@Override
	public DepartVO getDeptInfo(DepartVO vo) {
		return departMapper.selectOndDept(vo);
	}

	@Override
	public int insertDeptInfo(DepartVO vo) {
		int result = departMapper.insertDeptInfo(vo);
		System.out.println("id : " + vo.getDepartmentId());
		return result;
	}

	@Override
	public Map<String, Object> updateDeptList(List<DepartVO> vo) {
		Boolean result = false;
		List<Integer> successList = new ArrayList<>();
		int count = 0;
		for(DepartVO deptInfo : vo) {
			int res = departMapper.updateDeptInfo(deptInfo);
			if(res > 0) {
				//정상적으로 수정이 되었을 경우
				count += 1;
				successList.add(deptInfo.getDepartmentId());
			}
		}
		
		if(count > 0) {
			result = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("success", count);
		map.put("deptList", successList);
		
		return map;
	}

	@Override
	public int deleteDeptList(List<DepartVO> vo) {
		int count = 0;
		for(DepartVO deptInfo : vo) {
			count += departMapper.deleteDeptInfo(deptInfo.getDepartmentId());
		}
		return count;
	}

}
