package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter inter;
	private String re[];
	
	public MyImpl(SangpumInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void inputData() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("상품, 수량, 단가 입력 : ");
			String sang = sc.next();
			int su = sc.nextInt();
			int dan = sc.nextInt();
			re = inter.calcMoney(sang, su, dan);
		} catch (Exception e) {
			System.out.println("inputData err : " + e);
		}
		
	}
	@Override
	public void showData() {
		System.out.println("상품명 : " + re[0] + ", 금액 : " + re[1]);
		
	}
	
}
