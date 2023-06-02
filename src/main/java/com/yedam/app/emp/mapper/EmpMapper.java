package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectOne(int empNo);
	public List<EmpVO> selectList(EmpVO vo);
	public int insertEmp(EmpVO vo); // 등록
	//목록구하는 건수와 카운트 건수의 매개는 같아야 됨 cuz 페이징에 좋음ㅇㅇ
	public int deleteEmp(int empNo); //삭제
	public int updateEmp(EmpVO vo); // 수정

	public int selectCount(EmpVO vo);
	public List<Map<String, Object>> selectJob();
	//vo 대신에 map쓴거임ㅇㅇ
	public List<Map<String, Object>> selectDept();
	
}
