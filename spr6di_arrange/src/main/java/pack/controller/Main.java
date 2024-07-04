package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml");
		 */
		
		GenericXmlApplicationContext context = new 	GenericXmlApplicationContext("classpath:arrange.xml");
		MessageImpl impl1 = (MessageImpl)context.getBean("mImpl");
		impl1.sayHi();
		MessageImpl impl2 = (MessageImpl)context.getBean("mImpl");
		impl2.sayHi();
	
		System.out.println("객체 주소 : " + impl1 + " " + impl2); // 주소가 같다면 싱글톤 
		
		System.out.println("\n다형성 처리하세요.");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();

		System.out.println("\n다형성 처리하세요.2");
		MessageInter inter2 = (MessageInter)context.getBean("mImpl", MessageInter.class);
		inter2.sayHi();
		
		context.close();
	}

}