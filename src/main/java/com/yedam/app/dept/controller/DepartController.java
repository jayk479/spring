package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.mapper.DepartMapper;
import com.yedam.app.dept.service.DepartService;
import com.yedam.app.dept.service.DepartVO;
import com.yedam.app.dept.service.DeptListVO;

@Controller("deptInfo")
public class DepartController {
	@Autowired
	DepartService departService;
	
	@Autowired
	DepartMapper departMapper;

	// 경로를 등록하고, 그 경로와 기능 (+페이지까지 view)을 연결 하는 것이 컨트롤러의 역할
	// 경로가 Unique 해야 한다고 하지만
	// 경로 + method 했을 때 유니크해야됨ㅇㅇ
	
	// 조회(데이터, 페이지) -> GET
	// 등록, 수정, 삭제 -> POST
	
	
	// @RequestMapping(value = "deptList", method = [HttpMethod.POST])
	//전체조회
	//@RequestMapping("/deptList") 이하와 같음
	@GetMapping("/deptList")
	public String getDeptAllList(@RequestParam (required = false)String msg, Model model, HttpServletRequest request) {
		model.addAttribute("deptList", departService.getAllDept());
		//@RequestParam 는 선언하는 순간 필수값이 됨ㅇㅇ 그래서 (required = false) 붙여줌ㅇㅇ
		System.out.println("redirect : " + msg); 
		
		// ? = Object
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			System.out.println("department_id : " + flashMap.get("departmentId") );
		}
		
		return "dept/list";
	}
	
	// 단건조회 - 페이지
	@GetMapping("/deptInfo")
	public String getDeptpInfo(DepartVO vo, Model model) {
		DepartVO findDept = departService.getDeptInfo(vo);
		model.addAttribute("deptInfo", findDept);
		return "dept/info";
	}
	
	// 등록 - 페이지 : GET
	@GetMapping("/deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	// 등록 - 기능 : POST
//	@PostMapping("/deptInsert")
//	public String depptInsert(DepartVO vo, RedirectAttributes rtt) {
//		departService.insertDeptInfo(vo);
//		rtt.addFlashAttribute("departmentId", vo.getDepartmentId());
//		// 경로에 데이터 기재하면 보안상 문제
//		// insert 끝나고 vo는 끝났음ㅇㅇ
//		// addFlashAttribute 리다이렉트 할 때 정보를 세션에 저장함.
//		// => get방식으로 redirect되더라도 경로에 정보 필요xx
//		// 어차피 redirect는 get방식 밖에 안 됨ㅇㅇ
//		// 세션은 브라우저 단위로 유지 됨ㅇㅇ	
//		rtt.addAttribute("msg", "test"); // ?msg=test 이하처럼 나오는 방법임ㅇㅇ
//		//return "redirect:deptList?departmentId="+vo.getDepartmentId();
//		return "redirect:deptList";
//	}
	
	// 수정 - 기능 : POST
	// @RequestBody : json포맷을 사용하는 경우ㅇㅇ
	// 				-> content-type : 'application/json'
	@PostMapping("/deptUpdate")
	@ResponseBody // 응답하는 body에 필요한 데이터를 집어 넣는 어노테이션, 리턴타입이 스트링일 필요 없음ㅇㅇ
	//응답 할 때 내가 넘겨주는 데이터를 넣어줘라. 그럼 리다이렉트는 없어?
//	public Map<String, Object> deptUpdate(@RequestBody List<DepartVO> vo, RedirectAttributes rtt) {
//		//body 내부의 값을 parsing했을 때 어떤 형태로 보여 줄 지? 
//		//Map<String, Object> map = departService.updateDeptList(vo);
//		//rtt.addFlashAttribute("updateRes", map);
//		//return "redirect:deptInfo?departmentId="+vo.get(0).getDepartmentId();
//		return departService.updateDeptList(vo);
//	}
	
	public String deptUpdateText(@RequestBody List<DepartVO> vo, RedirectAttributes rtt) {
		
		return "success";
	}

	// 삭제 - 기능 : POST
	@PostMapping("deptDelete")
	public String deptDelete(DeptListVO list) {
		int result = departService.deleteDeptList(list.getDeptList());
		return "redirect:deptList?msg="+result;
	}
}
