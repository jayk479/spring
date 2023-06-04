package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	DeptMapper deptMapper;
	
	@GetMapping("deptList")	
	public String deptList(Model model, @ModelAttribute("dept") DeptVO vo) {
		model.addAttribute("DeptVO", vo);
		model.addAttribute("deptList", deptMapper.deptList(vo));
		
		return "dept/deptList";
	}
	
	//부서등록페이지로이동
	@GetMapping("deptInsert")
	public String deptInsertForm(Model model) {
		model.addAttribute("loca", deptMapper.selectLocation());
		return "dept/deptInsert";
	}
	
	@PostMapping("deptInsert")
	public String deptInsert(DeptVO vo) {
		deptMapper.deptInsert(vo);
		return "redirect:deptList";
	}
	
	//부서수정페이지로이동
	@GetMapping("deptUpdate")
	public String deptUpdateForm(Model model, int deptId) {
		model.addAttribute("dept", deptMapper.deptSelect(deptId));
		return "dept/deptUpdate";
	}
	
	@PostMapping("deptUpdate")
	public String deptUpdate(DeptVO vo) {
		deptMapper.deptUpdate(vo);
		return "redirect:deptList";
	}
	
	
}
