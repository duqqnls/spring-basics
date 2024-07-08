package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	@Autowired
	private ArticleInter articleInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/* 8라인 때문에 지워도 된다.
	public LogicImpl(ArticleInter articleInter) {
		this.articleInter = articleInter;
	}
	*/
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행");
		articleInter.selectAll(); //모델 클래스 수행 결과가 출력
	}
	
	@Override
	public void selectDataProcess2() {
		System.out.println("selectDataProcess2 처리");
		articleInter.selectAll(); //모델 클래스 수행 결과가 출력		
		System.out.println("*********");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("3초 지연 처리");
	}
}
