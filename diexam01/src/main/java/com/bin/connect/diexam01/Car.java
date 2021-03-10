package com.bin.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	// 빈에 등록되어 있는 Engine 인스턴스를 주입해 set가 필요가 없다.
	@Autowired 
	private Engine v8;
	

	public Car() {
		System.out.println("Car 생성");
	}
	
	
	public void setEngine(Engine v8) {
		this.v8 = v8;
	}


	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
	
}
