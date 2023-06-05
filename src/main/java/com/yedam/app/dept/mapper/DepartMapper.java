package com.yedam.app.dept.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.dept.service.DepartVO;

// 여기에는 어노테이션x 어노테이션==빈으로등록할것인가? 
// xml파일에서 다 정의해놔서 할 필요가 없음ㅇㅇ
// 예외, 매퍼에 관해 등록하는 경우 있음ㅇㅇ
public interface DepartMapper {
	//전체조회
	public List<DepartVO> selectAllDept();
	
	//단건조회
	public DepartVO selectOndDept(DepartVO vo);
	
	//등록
	public int insertDeptInfo(DepartVO vo);
	
	//수정
	public int updateDeptInfo(DepartVO vo);
	
	//삭제
	public int deleteDeptInfo(int deptNo);
	
	// 로케이션리스트
	public List<Map<String, Object>> selectLocation();

}
