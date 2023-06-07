package com.yedam.app;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.aop.AaaService;
import com.yedam.app.aop.Cats;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")

public class AopTest {
	
	@Autowired
	Cats myCat;
	
	@Autowired
	AaaService aService; //서비스어노테이션으로 붙인 이름과 동일시켜주기?
	
	//@Test
	public void aopTest() {
		Cats cat = new Cats(); // AOP작동xxx cuz Spring이 제어하지 않음
		cat.printInfo();
		System.out.println();
		myCat.printInfo();
	}
	
	
	@Test 
	public void txTest() {
		aService.insert();
	}

}
