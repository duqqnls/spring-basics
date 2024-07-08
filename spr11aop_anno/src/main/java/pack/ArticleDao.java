package pack;

import org.springframework.stereotype.Repository;

@Repository // DB와 연결에서 작업을 처리하는 모델 영역의 클래스임을 선언
public class ArticleDao implements ArticleInter{
	@Override
	public void selectAll() {
		System.out.println("테이블 자료 읽기");
		
	}
}
