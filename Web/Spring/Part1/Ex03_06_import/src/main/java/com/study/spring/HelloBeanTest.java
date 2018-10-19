package com.study.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {
	public static void main(String[] args) {
		
		String configLocation = "classpath:beans.xml";
				
		
		//1.Ioc 컨테이너 생성
		AbstractApplicationContext context =
				new GenericXmlApplicationContext(configLocation);
				
				
		//4.싱글톤인지 확인
		Hello hello = (Hello) context.getBean("hello");
		hello.print();
		
//		context.close();
	}
}
