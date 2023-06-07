package com.yedam.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // advice + pointcut 정보를 다 들고 있는 형태
@Component // 빈등록 이 빈은 일종의 aspect 설정파일같은거ㅇㅇ
public class LogAdvice {

	// 포인트컷 : 조인포인트 안에서 (비즈니스 로직과 관련된 메소드)들 중에서 Advice가 가지게 되는 메소드
	// == 조인포인트(비즈니스 로직과 관련된 메소드) 중에서 advice(공통코드)가 적용될 메소드
	// 실질적으로는 어노테이션을 기반으로 설정
	@Pointcut("within(com.yedam.app.aop.*)") // 지정된 패키지 아래에 있는 모든 메소드 선택ㅇㅇ	
	public void allPointCut() {}

	// Weaving : 포인트컷 + Advice + 동작시점
	@Around("allPointCut()") // 동작시점(around는 동작전후)
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable{ // 여기가 Advice부분
		// AOP가 적용되는 메서드의 정보 가져오기
		// 이름
		String signatureStr = joinpoint.getSignature().toString(); // 호출되는 메서드에 대한 정보를 구한다.== 여기서는 이름ㅇㅇ
		System.out.println("시작 : " + signatureStr);
		//공통기능
		System.out.println("핵심기능전실행 - 공통기능 : " + System.currentTimeMillis());
		try {
			Object obj = joinpoint.proceed(); //실제로 joinpoint가 동작하는 시점ㅇㅇ 지금 proceed() 뭔지 모름
			return obj; 
			// 해당 비지니스로직의 기능 실행 결과를 리턴해야함ㅇㅇ 
			// 메소드가 리턴시킬 타입이 뭔지 몰라서 가장 최상위 클래스로 리턴하는 것 뿐임ㅇㅇ object
		} finally  {
			// 공통기능
			System.out.println("핵심기능후실행 - 공통기능 : " + System.currentTimeMillis());
		}
	}

}
