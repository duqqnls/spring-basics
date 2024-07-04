package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 처리 1 : 전통적 방법
		Message1 m1 = new Message1();
		m1.sayHello("레서판다");
		
		Message2 m2 = new Message2();
		m2.sayHello("냐옹아");
		
		System.out.println();
		MessageInter inter;
		inter = m1;
		inter.sayHello("여빈");
		inter = m2;
		inter.sayHello("duqqnls");
		
		// 처리 2 : Spring 방법
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MessageInter inter2 = (MessageInter)context.getBean("mes1");
		inter2.sayHello("콩콩");
		MessageInter inter3 = (MessageInter)context.getBean("mes2");
		inter3.sayHello("냐옹");
	}

}
