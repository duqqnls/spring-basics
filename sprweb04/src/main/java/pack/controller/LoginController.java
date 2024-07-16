package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller // 클라이언트의 요청을 받아 모델에 다녀와서 모델에 다녀온 결과값을 뷰 파일을 통해 처리하는 파일임을 명시
public class LoginController {
	// 로그 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); // 현재 클래스에 적용함을 적어준다 -> this:getclass()

	@GetMapping("login")
	public String submitCall() {
		// return "login.html"; // forward : 기본 값이라서, webapp으로 안감   
		
		return "redirect:login.html"; // redirect 명시적 적어주어야함
		// return "redirect:http://localhost/login.html";	
	}
	
	// 클라이언트가 전달한 값 수신 방법 1 : 전통적
	/*
	// String라고 적었기 때문에 Model model 적기
	// ModelAndView라고 적었다면, Model model 생략 
	@PostMapping("login")
	public String submit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + " " + pwd); // 출력 확인하는 방법 1 
		logger.info(id + " " + pwd); 		// 출력 확인하는 방법 2  로그레벨 trace > debug > info > warn > error > fatal 순서임. 해석 : 확인하고싶은 정보를 출력할 수 있음. // 콘솔에서 확인 가능 
		
		String data = "";
		if(id.equals("duqqnls") && (pwd.equals("123")))
			data = "로그인 성공";
		else
			data = "로그인 실패";
		model.addAttribute("data", data);
		
		return "result";  // forward 이고, views에 있는 result.jsp를 호출 
	}
	*/
	
	// 클라이언트가 전달한 값 수신 방법 2 : Spring 어노테이션 사용
	@PostMapping("login")
	public String submit(@RequestParam(value="id")String id,
						 // @RequestParam(value="pwd")String pwd,// 원래 클라이언트가 입력하는 값은 무조건 String으로 들어옴 -> login.html
						 // @RequestParam(value="pwd")int pwd,   // 58라인과 같음. 강제 형변환
							@RequestParam(value="pwd", defaultValue = "123")int pwd, // 클라이언트가 default로 입력시 123으로 자동 인식되어 로그인 성공
						 Model model) { // value의 id/pwd는 name="id","pwd"를 각각 가르킴 
		
		String data = "";
		// if(id.equals("duqqnls") && pwd.equals("123"))
		if(id.equals("duqqnls") && pwd == 123) // 클라이언트가 입력해주는 값은 모두 String임 (무조건) 그래서 50-51라인에 강제로 형변환했음 int형 타입으로 
			data = "로그인 성공";
		else
			data = "로그인 실패";
		model.addAttribute("data", data);		
		
		return "result";
	}
}
