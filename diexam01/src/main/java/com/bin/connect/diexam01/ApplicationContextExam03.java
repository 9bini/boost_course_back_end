package com.bin.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {
	private static ApplicationContext ac;

	public static void main(String[] args) {
		ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		// 리턴 타입이 Car인것을 가져온다.
		Car car = (Car)ac.getBean(Car.class);
		
		car.run();
	}

}
