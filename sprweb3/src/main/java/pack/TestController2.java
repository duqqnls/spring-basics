package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 어노테이션 1번 방법 ***
@Controller  
public class TestController2 {
	@RequestMapping(value="test9", method=RequestMethod.GET)
	public String def1(Model model) {
		model.addAttribute("msg", "success get");
		return "list";
	}
	
	@RequestMapping(value="test9", method=RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg", "success post");
		return "list";
	}
}

// 어노테이션 2번 방법 ***
/*
@Controller
@RequestMapping("test9") // test9의 요청이 들어올 거임

public class TestController2 {
	@RequestMapping(method=RequestMethod.GET)
	public String def1(Model model) {
		//HttpServletRequest 객체에 값을 저장 후 뷰에 전달
		model.addAttribute("msg", "success get");
		return "list"; // forwarding 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg", "success post");
		return "list";
	}
}

*/
