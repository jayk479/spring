package com.yedam.app.aop;

import lombok.Data;

@Data
public class Cats {
	private String name;
	private int age;
	private String color;
	
	//spring이 인식해야해서 bean등록해줘야함ㅇㅇ
	
	public void printInfo() {
		System.out.println(this.name + ", " + this.age + ", " + this.color);
	}
}
