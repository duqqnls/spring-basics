package pack.model;

public class SangpumImpl implements SangpumInter {

	@Override
	public String[] calcMoney(String sang, int su, int dan) {
		String[] re = new String[2];
		re[0] = sang;
		re[1] = Integer.toString(su * dan); 
		return re;
	}
}
