package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/* 사용 1 
// @RestController : @Controller + @ResponseBody 어노테이션을 결합한 것 
@RestController // 각각의 메서드가 객체를 직접 반환하고, 자동으로 JSON 또는 XML 형태로 변환되어 HTTP 응답 본문에 포함됨 
public class TestController {	
	@RequestMapping("test1")  //어떤 요청인지 기재해주어야함 -> 해석: index.html속 test1에 대한 요청 처리  
	public String abc() {          
		return " 요청에 대한 반응 보이기 ";  
	}
}
*/

// 사용 2
@Controller 				  // 사용자의 요청을 처리한 후 지정된 뷰(템플릿 엔진:jsp...)에 모델 객체를 넘겨주는 역할
public class TestController { 	
	@RequestMapping("test1")  // test1의 요청이 들어옴 // get, post 모두 처리 
	public ModelAndView abc() { 
		// System.out.println("abc 처리");
		// return null;
		
		// return new ModelAndView("list", "msg", "안녕? jsp"); //참고 view : list 
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		// request.setAttribute("msg", "안녕? jsp");
		// HttpServletRequest를 사용해 키, 값으로 jsp에 전송
		modelAndView.addObject("msg", "안녕? jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="test2", method=RequestMethod.GET)  // test2의 요청이 들어옴 + get 요청
	public ModelAndView abc2() { 
		return new ModelAndView("list", "msg", "성공2");			
	}
	
	@GetMapping(value="test3")  // test3의 요청 처리 + @Getmapping : Get만 된다!
	public ModelAndView abc3() { 
		return new ModelAndView("list", "msg", "성공3");		
	}
	
	@GetMapping(value="test4")  // test4의 요청 처리 - get
	public String abc4(Model model) { 
		model.addAttribute("msg", "성공4"); // setAttribue와 같은 뜻  
		return "list";		
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST)  // test5 요청 처리 - post
	public ModelAndView abc5() { 
		return new ModelAndView("list", "msg", "성공5");			
	}
	
	@PostMapping(value="test6")  // test4의 요청 처리 - get
	public ModelAndView abc6() { 
		return new ModelAndView("list", "msg", "성공6");		
	}
	
	@PostMapping(value="test7")  // test4의 요청 처리 - get
	public String abc7(Model model) { 
		model.addAttribute("msg", "성공7");
		return "list";		
	}
	
	@GetMapping(value="test8")  // test8 데이터 얻기 (get)
	@ResponseBody // 자동으로 JSON 또는 XML 형태로 변환되어 HTTP 응답 본문에 포함
	public String abc8() { 
		String value = "일반 데이터 - String, Map, JSON 등을 전달 가능";
		return value;
	}	
	
	@GetMapping(value="test8_1")  // test8_1 데이터 얻기 (get)
	@ResponseBody // 자동으로 JSON 또는 XML 형태로 변환되어 HTTP 응답 본문에 포함
	public DataDto abc8_1() { // Json 타입으로 return하기		
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("여빈");
		return dto; // JSON 형태로 반환 (Jackson 라이브러리가 지원)
	}	
}
