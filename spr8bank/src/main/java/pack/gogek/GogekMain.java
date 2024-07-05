package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");

		Gogek duqqnls = (Gogek)context.getBean("gogek");
		duqqnls.selectBank("sinhan");
		duqqnls.playInputMoney(500);
		duqqnls.playOutputMoney(200);
		System.out.print("duqqnls - ");
		duqqnls.showMoney();
		
		Gogek panda = (Gogek)context.getBean("gogek");
		panda.selectBank("sinhan");
		panda.playInputMoney(500);
		panda.playOutputMoney(200);
		System.out.print("panda - ");
		panda.showMoney();
		
		Gogek cat = (Gogek)context.getBean("gogek");
		cat.selectBank("hana");
		cat.playInputMoney(500);
		cat.playOutputMoney(100);
		System.out.print("cat - ");
		cat.showMoney();
		
		System.out.println("객체 주소 duqqnls : " + duqqnls);
		System.out.println("객체 주소 panda : " + panda);
		System.out.println("객체 주소 cat : " + cat);
		
		
	}

}
