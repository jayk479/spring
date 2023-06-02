package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {

	@Autowired
	EmpMapper empMapper; // 인터페이스를 상속받은 구현클래스를 주입 받음

	@Ignore
	public void getEmpInfo() {
		EmpVO findEmp = empMapper.selectOne(100);
		assertEquals(findEmp.getFirstName(), "Steven"); // 두 개의 값이 같은지 비교하는 거ㅇㅇ
	}
	

	@Ignore
	public void 전체조회() {
		EmpVO param = new EmpVO();
		 //param.setDepartmentId("50");
		 //param.setFirstName("e");
		 //param.setOrderColumn("department_id, first_name");
		param.setDepartmentId("50, 20, 90");
		List<EmpVO> list = empMapper.selectList(param);
		int cnt = empMapper.selectCount(param);
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
		
		//assertEquals(list.get(0).getEmployeeId(), "100");
		//System.out.println(list.get(0));
	}

	@Ignore
	public void insertTest() {
		EmpVO vo = new EmpVO();
		//vo.setEmployeeId("777");
		vo.setHireDate("23/06/02");
		vo.setJobId("IT_PROG");
		vo.setEmail("test4");
		vo.setLastName("test");

		//int result = empMapper.insertEmp(vo);
		empMapper.insertEmp(vo);
		System.out.println(vo.getEmployeeId());
		//assertEquals(result, 1);
		
		// mapper 인터페이스를 void로 했으면 단건조회 해서 다시 테스트ㅇㅇ
		// 테스트는 무조건 assert 이걸로 테스트해야함ㅇㅇ
	}
	
	@Test
	public void selectJob() {
		List<Map<String, Object>> list = empMapper.selectJob();
		assertNotNull(list);
	}

}
