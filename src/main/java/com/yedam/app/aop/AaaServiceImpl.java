package com.yedam.app.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("aService")
public class AaaServiceImpl implements AaaService {

	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional 
	//복수의 SQL문을 하나로 만듦. 중간에 하나라도 실패하면 전부 롤백ㅇㅇ
	//트랜잭션매니저가 작동시킴
	// 기본적으로 마이바티스는 SQL문은 각각 작용하게함
	// BUT @Transactional 붙이면 모든 SQL문이 성공해야 COMMIT, 아니면 전체 ROLLBACK
	// AOP를 기반으로 ㅇㅇㅇ
	@Override
	public void insert() { //행번호 화살표 =  aop등록되어 어느 시점에 AOP 붙었는지 알 수 있음
		aaaMapper.insert("101");
		aaaMapper.insert("901");
	}

}
