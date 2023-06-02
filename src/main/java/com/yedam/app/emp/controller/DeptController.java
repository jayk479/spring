package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	DeptMapper deptMapper;
	
	@GetMapping("deptList")	
	public String deptList(Model model, DeptVO vo) {
		model.addAttribute("DeptVO", vo);
		model.addAttribute("deptList", deptMapper.deptList(vo));
		return "dept/deptList";
	}
	
	
}
