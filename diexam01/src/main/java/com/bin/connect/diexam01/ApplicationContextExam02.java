package com.bin.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {
	private static ApplicationContext ac;

	public static void main(String[] args) {
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		Car car = (Car)ac.getBean("c");
		car.run();
	}

}
