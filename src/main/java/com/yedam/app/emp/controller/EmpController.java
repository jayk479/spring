package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
 * command
 * pojo : 상속필요없음
 * 
 * */

@Controller 
// 객체생성해서 컨테이너에 빈등록하고 스프링 디스패처서블릿에서 호출 할 수 있도록 커맨드 타입으로 만들어줌
// @Component 상속 받음
public class EmpController {
	
	@Autowired
	EmpMapper empMapper;
	
	//@RequestMapping
	//조회는 get 
	@GetMapping("empList")	
	public String empList(Model model, @ModelAttribute("emp") EmpVO vo) {
		// 브라우저에서 리퀘스트 되는 파라메터 들은 EmpVO로 들어감 필드 이게 커맨드 객체ㅇㅇ
		// 그래서 이렇게 담은 vo가 매퍼의 쿼리까지 전달 됨ㅇㅇ
		// @ModelAttribute("emp") EmpVO vo객체를 emp라는 이름으로 쓸 수 있게 함ㅇㅇ
		// 보낸데이터를 유지해야 할 때 주로 사용
		model.addAttribute("empVO", vo); //커맨드 객체
		model.addAttribute("empList", empMapper.selectList(vo));
		//System.out.println(vo);
		return "emp/empList";
//boomerang test http://localhost:8081/app/empList?departmentId=50,40&firstName=e&orderColumn=first_name
	}
	
	//사원등록페이지로이동
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("jobs", empMapper.selectJob());
		model.addAttribute("depts", empMapper.selectDept());
		return "emp/empInsert";
	}
	
	//사원등록처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		return "redirect:empList"; // forward redirect 
		//부메랑 post는 form
	}
	
	//사원삭제처리
	@GetMapping("deleteEmp")
	//@RequestParam 생략가능 = req.getParameter()
	public String empDelete(@RequestParam int empId) {
		empMapper.deleteEmp(empId);
		System.out.println(empId);
		return "redirect:empList";
	}
	
	//사원수정페이지로이동
	@GetMapping("updateEmp")
	public String empUpdateForm(Model model, int empId) {
		model.addAttribute("emp", empMapper.selectOne(empId));
		model.addAttribute("jobs", empMapper.selectJob());
		model.addAttribute("depts", empMapper.selectDept());
		return "emp/empUpdate";
	}
	
	
	//사원정보수정처리
	@PostMapping("updateEmp")
	public String empUpdate(EmpVO vo) {
		empMapper.updateEmp(vo);
		System.out.println(vo);
		return "redirect:empList";
	}
}
