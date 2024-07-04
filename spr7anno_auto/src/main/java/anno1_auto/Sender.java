package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component	// single pattern 으로 sender 객체가 생성. 객체 변수명은 sender
// @Component("sender") 
// @Component("sen")
// @Scope("singleton") // 또는 객체변수를 계속 생성하는 @Scope(prototype) 
public class Sender {
	public void show() {
		System.out.println("Sender의 show Method 수행");

	}
}
