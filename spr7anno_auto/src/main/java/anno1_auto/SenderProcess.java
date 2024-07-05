package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// 참고 : 계층(Layers)별 어노테이션 구분
// Application layer : 클라이언트와 데이터 입출력을 제어 @Controller..
// Domain layer : 어플리케이션 중심이며, 업무 처리를 담당
// Infrastructor layer : DB에 대한 영속성(persistence)등을 담당 @Repository ...

// @Component
@Service 
// @Service("SenderProcess") -> 같은 의미 1
// @Scope("singleton") -> 같은 의미 2
public class SenderProcess { // 요청을 통해 결과를 보여주는 화면 
	// @Autowired : Bean의 자동 삽입을 위해 사용하는 어노테이션. (name에 의한 매핑이 아니라 type으로 매핑)
	
	@Qualifier("sender2")
	@Autowired				 // field injection : 간단하나 테스트 불편. 주로 사용
	//private Sender sender;
	private SenderInter senderInter;
	
	/*
	@Autowired				 // setter injection : 코드가 장황하다.
	public void setSender(Sender sender) {
		this.sender = sender;		
	}
	
	@Autowired				 // constructor injection : 불변성과 테스트가 편하지만 생성자가 너무 많아진다. 
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	*/
	
	public void dispData() {
		senderInter.show();		
	}	
}
