package com.yedam.app.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.user.service.UserVO;

//@Controller
@RestController //해당 컨트롤러의 모든 메소드는 데이터를 반환한다 == 페이지반환xxxx only data반환ㅇㅇ
public class UserRestController {
	
	@PostMapping("insertUser")
	//@ResponseBody 
	// 상기 @Controller어노테이션이 붙으면 기본적으로 페이지를 반환한다 
	// 그러나 @ResponseBody가 붙으면 예외적으로 반환하는 것이 데이터(객체)가 됨
	public UserVO insertUser(UserVO userVO) {
		System.out.println("name : " + userVO.getName());
		System.out.println("age : " + userVO.getAge());
		return userVO;
	} 
	
	@GetMapping("getHome")
	public String getHome() {
		return "home";
	}
	
}
