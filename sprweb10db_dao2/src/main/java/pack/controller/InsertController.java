package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.MemberDao;

@Controller
public class InsertController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("insert")
	public String form() {
		return "insform"; // forward이다 
	}
	
	@PostMapping("insert")
	public String submit(MemberBean bean) {
		memberDao.insData(bean);
		return "redirect:/list";
		// return "list"; // 바로 list를 부르면 추가한 내용이 안 보임. 그래서 forward 하면 안 됌. redirect 해서 새로운 내용 읽어와야함 
	}
}
