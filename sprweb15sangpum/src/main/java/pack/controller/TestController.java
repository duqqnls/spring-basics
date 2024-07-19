package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.Sangpum;


@Controller
public class TestController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("/") // 모든 요청이 들어온다.
	public String main() {
		return "main";

	}
	
	@GetMapping("testjpa") // testjpa 요청이 들어온다.
	public String list(Model model) {
		ArrayList<Sangpum> slist = (ArrayList<Sangpum>)dataDao.getDataAll(); // MVC 패턴 응용
		model.addAttribute("datas", slist); // model에 있는 datas를 slist에 담아서 간다 
		return "list";
	}
	
	@GetMapping("search") // search 요청이 들어온다.
	public String searchList(FormBean bean, Model model) {
		ArrayList<Sangpum> slist = (ArrayList<Sangpum>)dataDao.getDataSearch(bean.getSearchValue()); 
		model.addAttribute("datas", slist); 
		return "list";
	}
}
